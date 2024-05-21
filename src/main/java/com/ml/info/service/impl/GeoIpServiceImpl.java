package com.ml.info.service.impl;

import com.ml.info.client.dto.countryinfo.ResponseCountryInfoDTO;
import com.ml.info.client.dto.currencyinfo.ResponseCurrencyDTO;
import com.ml.info.client.dto.searchip.ResponseSearchIpDTO;
import com.ml.info.client.integration.CountryInfoApiService;
import com.ml.info.client.integration.CurrencyInfoApiService;
import com.ml.info.client.integration.SearchIpApiService;
import com.ml.info.model.InfoStatistic;
import com.ml.info.model.ResponseInfo;
import com.ml.info.service.GeoIpService;
import com.ml.info.util.ApiUtil;
import com.ml.info.util.Constants;
import com.ml.info.util.MapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.ml.info.util.Constants.*;

/**
 * Implementacion servicion geolocalizacion de IP
 */
@Service
@RequiredArgsConstructor
public class GeoIpServiceImpl implements GeoIpService {

    private final SearchIpApiService searchIpApiService;
    private final CountryInfoApiService countryInfoApiService;
    private final CurrencyInfoApiService currencyInfoApiService;
    private final MapperService mapperService;
    private final ApiUtil apiUtil;
    private InfoStatistic infoStatistic;

    /**
     * Geolocalizar ip
     * @param ip ip a localizar
     * @return Respuesta servicio con la informacion de la ip
     */
    @Override
    public ResponseInfo requestInfoIP(String ip) {

        ResponseInfo finalResponseInfo = ResponseInfo.builder().build();
        ResponseSearchIpDTO responseSearchIpDTO = searchIpApiService.searchInfoIp(ip);
        ResponseCountryInfoDTO responseCountryInfoDTO = countryInfoApiService.searchCountryInfo(ip);
        ResponseCurrencyDTO responseCurrencyDTO = currencyInfoApiService.searchCurrencyInfo(responseCountryInfoDTO.getCurrencyDTO().getCurrencyCode(), BUSINESS_TARGETED_EXCHANGE);
        finalResponseInfo.setIp(ip);
        finalResponseInfo.setFechaactual(apiUtil.getZonedDate());
        finalResponseInfo.setPais(responseCountryInfoDTO.getCountry());
        finalResponseInfo.setISOCode(responseCountryInfoDTO.getCountryCode());
        finalResponseInfo.setIdiomas(mapperService.mapLanguages(responseSearchIpDTO.getLocation().getLanguageDTOS()));
        finalResponseInfo.setMoneda(responseCurrencyDTO.toStringUsd());
        finalResponseInfo.setHora(apiUtil.getArgZoneDate(responseCountryInfoDTO.getTimezoneDTO().getName()));
        finalResponseInfo.setDistanciaestimada(getFixedValueDistance(responseCountryInfoDTO,responseCountryInfoDTO.getCountry()));
        return finalResponseInfo;
    }

    /**
     * Consulta estadistica de trafico de servicio
     * @return Descripcion del trafico
     */
    @Override
    public String getStatisticMachine() {
        if (infoStatistic != null){
            double a = infoStatistic.getDistanciaPMC()* infoStatistic.getInvocacionesPMC();
            double b = infoStatistic.getDistanciaPML()* infoStatistic.getInvocacionesPML();
            double c = (a + b)/(infoStatistic.getInvocacionesPML()+ infoStatistic.getInvocacionesPMC());
            return BUSINESS_MESSAGE_DISTANCIA_PROMEDIO + c +"\n"+
                    BUSINESS_MESSAGE_DISTANCIA_MAS_CERCANA_A_BUENOS_AIRES + infoStatistic.getDistanciaPMC() +"\n"+
                    BUSINESS_MESSAGE_DISTANCIA_MAS_LEJANA_A_BUENOS_AIRES + infoStatistic.getDistanciaPML()
            ;
        }else {
            return BUSINESS_MESSAGE_SIN_TRAFICO;
        }
    }

    /**
     * Obtener distancia entre buenos aires(argentina) y la direccion IP suministradaa
     * @param responseCountryInfoDTO Informacion del request de la peticion
     * @param nameCountry nombre del pais al que pertenece la IP
     * @return String valor distancia
     */
    private String getFixedValueDistance(ResponseCountryInfoDTO responseCountryInfoDTO, String nameCountry){
        String finalDistance = ApiUtil.distanceBetween(Constants.BUSINESS_CALCULATE_DISTANCE_VALUE_ARG_LAT, Constants.BUSINESS_CALCULATE_DISTANCE_VALUE_ARG_LONG, responseCountryInfoDTO.getLatitude(), responseCountryInfoDTO.getLongitude());
        updateStatistic(finalDistance,nameCountry);
        return finalDistance + " kms  ("+Constants.BUSINESS_CALCULATE_DISTANCE_VALUE_ARG_LAT + ", " +Constants.BUSINESS_CALCULATE_DISTANCE_VALUE_ARG_LONG + ") a ("+ responseCountryInfoDTO.getLatitude() + ", " + responseCountryInfoDTO.getLongitude()+")";
    }

    /**
     * Actualizar trafico en memoria
     * @param distance distancia calculada
     * @param nameCountry nombre del pais que pertenece a la IP
     */
    private void updateStatistic(String distance, String nameCountry){
        double distanceRequest = Double.parseDouble(distance);
        //INIT
        if (infoStatistic == null){
            infoStatistic = InfoStatistic.builder()
                    .invocacionesPML(1)
                    .invocacionesPMC(1)
                    .nombrePMC(nameCountry)
                    .nombrePML(nameCountry)
                    .distanciaPML(distanceRequest)
                    .distanciaPMC(distanceRequest)
                    .build();
        }else {
            //REBOOT
            if (distanceRequest > infoStatistic.getDistanciaPML()){
                infoStatistic.setDistanciaPML(distanceRequest);
                infoStatistic.setNombrePML(nameCountry);
                infoStatistic.setInvocacionesPML(0);
            }
            if (distanceRequest < infoStatistic.getDistanciaPMC()){
                infoStatistic.setDistanciaPMC(distanceRequest);
                infoStatistic.setNombrePMC(nameCountry);
                infoStatistic.setInvocacionesPMC(0);
            }
            //PLUS
            if(infoStatistic.getNombrePML().equals(nameCountry)){
                infoStatistic.setInvocacionesPML(infoStatistic.getInvocacionesPML()+1);
            }
            if(infoStatistic.getNombrePMC().equals(nameCountry)){
                infoStatistic.setInvocacionesPMC(infoStatistic.getInvocacionesPMC()+1);
            }
        }
    }
}

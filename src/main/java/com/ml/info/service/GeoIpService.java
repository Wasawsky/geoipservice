package com.ml.info.service;

import com.ml.info.model.ResponseInfo;

/**
 * Interfaz servicio geolocalizacion de IP
 */
public interface GeoIpService {

    /**
     * Geolocalizar ip
     * @param ip ip a localizar
     * @return Respuesta servicio con la informacion de la ip
     */
    ResponseInfo requestInfoIP(String ip);

    /**
     * Consulta estadistica de trafico de servicio
     * @return Descripcion del trafico
     */
    String getStatisticMachine();
}

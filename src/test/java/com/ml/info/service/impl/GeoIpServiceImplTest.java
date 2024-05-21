package com.ml.info.service.impl;

import com.ml.info.client.dto.countryinfo.CurrencyDTO;
import com.ml.info.client.dto.countryinfo.ResponseCountryInfoDTO;
import com.ml.info.client.dto.countryinfo.TimezoneDTO;
import com.ml.info.client.dto.currencyinfo.ExchangeRatesDTO;
import com.ml.info.client.dto.currencyinfo.ResponseCurrencyDTO;
import com.ml.info.client.dto.searchip.LocationDTO;
import com.ml.info.client.dto.searchip.ResponseSearchIpDTO;
import com.ml.info.client.integration.CountryInfoApiService;
import com.ml.info.client.integration.CurrencyInfoApiService;
import com.ml.info.client.integration.SearchIpApiService;
import com.ml.info.model.InfoStatistic;
import com.ml.info.model.ResponseInfo;
import com.ml.info.util.ApiUtil;
import com.ml.info.util.MapperService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GeoIpServiceImplTest {
    @Mock
    SearchIpApiService searchIpApiService;
    @Mock
    CountryInfoApiService countryInfoApiService;
    @Mock
    CurrencyInfoApiService currencyInfoApiService;
    @Mock
    MapperService mapperService;
    @Mock
    ApiUtil apiUtil;
    @Mock
    InfoStatistic infoStatistic;
    @InjectMocks
    GeoIpServiceImpl geoIpServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        geoIpServiceImpl = new GeoIpServiceImpl(searchIpApiService,countryInfoApiService,currencyInfoApiService,mapperService,apiUtil);
    }

    @Test
    void testRequestInfoIP() {
        when(searchIpApiService.searchInfoIp(anyString())).thenReturn(new ResponseSearchIpDTO(LocationDTO.builder().build(), 1.1f, 1.1f));
        when(countryInfoApiService.searchCountryInfo(anyString())).thenReturn(new ResponseCountryInfoDTO("country", "countryCode", TimezoneDTO.builder().name("America/Bogota").build(), CurrencyDTO.builder().currencyCode("USD").currencyName("USD").build(), 1.1f, 1.1f));
        when(currencyInfoApiService.searchCurrencyInfo(anyString(), anyString())).thenReturn(new ResponseCurrencyDTO("base", 0, ExchangeRatesDTO.builder().usd(45.65f).build()));
        when(mapperService.mapLanguages(any())).thenReturn("mapLanguagesResponse");

        ResponseInfo result = geoIpServiceImpl.requestInfoIP("8.8.8.8");
        Assertions.assertEquals("8.8.8.8", result.getIp());
    }

    @Test
    void testRequestInfoIPMultiple() {
        when(searchIpApiService.searchInfoIp(anyString())).thenReturn(new ResponseSearchIpDTO(LocationDTO.builder().build(), 1.1f, 1.1f));
        when(countryInfoApiService.searchCountryInfo(anyString())).thenReturn(new ResponseCountryInfoDTO("country", "countryCode", TimezoneDTO.builder().name("America/Bogota").build(), CurrencyDTO.builder().currencyCode("USD").currencyName("USD").build(), 1.1f, 1.1f));
        when(currencyInfoApiService.searchCurrencyInfo(anyString(), anyString())).thenReturn(new ResponseCurrencyDTO("base", 0, ExchangeRatesDTO.builder().usd(45.65f).build()));
        when(mapperService.mapLanguages(any())).thenReturn("mapLanguagesResponse");

        ResponseInfo result = geoIpServiceImpl.requestInfoIP("8.8.8.8");
        Assertions.assertEquals("8.8.8.8", result.getIp());

        ResponseInfo result2 = geoIpServiceImpl.requestInfoIP("1.8.8.8");
        Assertions.assertEquals("1.8.8.8", result2.getIp());
    }

    @Test
    void testRequestInfoIPMultipleHigh() {
        when(searchIpApiService.searchInfoIp(anyString())).thenReturn(new ResponseSearchIpDTO(LocationDTO.builder().build(), 1.1f, 1.1f));
        when(countryInfoApiService.searchCountryInfo(anyString())).thenReturn(new ResponseCountryInfoDTO("country1", "countryCode", TimezoneDTO.builder().name("America/Bogota").build(), CurrencyDTO.builder().currencyCode("USD").currencyName("USD").build(), 1.1f, 1.1f),new ResponseCountryInfoDTO("country2", "countryCode", TimezoneDTO.builder().name("America/Bogota").build(), CurrencyDTO.builder().currencyCode("USD").currencyName("USD").build(), 10.1f, 10.1f));
        when(currencyInfoApiService.searchCurrencyInfo(anyString(), anyString())).thenReturn(new ResponseCurrencyDTO("base", 0, ExchangeRatesDTO.builder().usd(45.65f).build()));
        when(mapperService.mapLanguages(any())).thenReturn("mapLanguagesResponse");

        ResponseInfo result = geoIpServiceImpl.requestInfoIP("8.8.8.8");
        Assertions.assertEquals("8.8.8.8", result.getIp());

        ResponseInfo result2 = geoIpServiceImpl.requestInfoIP("1.8.8.8");
        Assertions.assertEquals("1.8.8.8", result2.getIp());

        String stats = geoIpServiceImpl.getStatisticMachine();
        Assertions.assertFalse(stats.isEmpty());
    }

    @Test
    void testRequestInfoIPMultipleLow() {
        when(searchIpApiService.searchInfoIp(anyString())).thenReturn(new ResponseSearchIpDTO(LocationDTO.builder().build(), 1.1f, 1.1f));
        when(countryInfoApiService.searchCountryInfo(anyString())).thenReturn(new ResponseCountryInfoDTO("country2", "countryCode", TimezoneDTO.builder().name("America/Bogota").build(), CurrencyDTO.builder().currencyCode("USD").currencyName("USD").build(), 10.1f, 10.1f),new ResponseCountryInfoDTO("country1", "countryCode", TimezoneDTO.builder().name("America/Bogota").build(), CurrencyDTO.builder().currencyCode("USD").currencyName("USD").build(), 1.1f, 1.1f));
        when(currencyInfoApiService.searchCurrencyInfo(anyString(), anyString())).thenReturn(new ResponseCurrencyDTO("base", 0, ExchangeRatesDTO.builder().usd(45.65f).build()));
        when(mapperService.mapLanguages(any())).thenReturn("mapLanguagesResponse");

        ResponseInfo result = geoIpServiceImpl.requestInfoIP("8.8.8.8");
        Assertions.assertEquals("8.8.8.8", result.getIp());

        ResponseInfo result2 = geoIpServiceImpl.requestInfoIP("1.8.8.8");
        Assertions.assertEquals("1.8.8.8", result2.getIp());
    }

    @Test
    void testGetStatisticMachine() {
        String result = geoIpServiceImpl.getStatisticMachine();
        Assertions.assertFalse(result.isEmpty());
    }

}
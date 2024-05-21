package com.ml.info.client.integration.impl;

import com.ml.info.client.adapter.CountryInfoAdapterFeign;
import com.ml.info.client.dto.countryinfo.CurrencyDTO;
import com.ml.info.client.dto.countryinfo.ResponseCountryInfoDTO;
import com.ml.info.client.dto.countryinfo.TimezoneDTO;
import com.ml.info.config.EnvironmentVariables;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CountryInfoApiServiceImplTest {
    @Mock
    CountryInfoAdapterFeign countryInfoAdapterFeign;
    @Mock
    EnvironmentVariables variables;
    @InjectMocks
    CountryInfoApiServiceImpl countryInfoApiServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        countryInfoApiServiceImpl = new CountryInfoApiServiceImpl(countryInfoAdapterFeign,variables);
    }

    @Test
    void testSearchCountryInfo() {
        when(countryInfoAdapterFeign.getCountryInfoIp(anyString(), anyString(), anyString())).thenReturn(new ResponseEntity<ResponseCountryInfoDTO>(new ResponseCountryInfoDTO("Uruguay", "countryCode", new TimezoneDTO("name", "abbreviation", 0, "currentTime", Boolean.TRUE), new CurrencyDTO("currencyName", "currencyCode"), 1.1f, 1.1f), null, 200));
        when(variables.getCountryAccessKey()).thenReturn("getCountryAccessKeyResponse");

        ResponseCountryInfoDTO result = countryInfoApiServiceImpl.searchCountryInfo("ip");
        Assertions.assertTrue(result.getCountry().equals("Uruguay"));
    }
}


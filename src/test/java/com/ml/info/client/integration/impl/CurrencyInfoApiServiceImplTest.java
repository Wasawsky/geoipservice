package com.ml.info.client.integration.impl;

import com.ml.info.client.adapter.CurrencyInfoAdapterFeign;
import com.ml.info.client.dto.currencyinfo.ExchangeRatesDTO;
import com.ml.info.client.dto.currencyinfo.ResponseCurrencyDTO;
import com.ml.info.config.EnvironmentVariables;
import feign.FeignException;
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
class CurrencyInfoApiServiceImplTest {
    @Mock
    CurrencyInfoAdapterFeign currencyInfoAdapterFeign;
    @Mock
    EnvironmentVariables variables;
    @InjectMocks
    CurrencyInfoApiServiceImpl currencyInfoApiServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        currencyInfoApiServiceImpl = new CurrencyInfoApiServiceImpl(currencyInfoAdapterFeign,variables);
    }

    @Test
    void testSearchCurrencyInfo() {
        when(currencyInfoAdapterFeign.getCurrencyInfo(anyString(), anyString(), anyString())).thenReturn(new ResponseEntity<ResponseCurrencyDTO>(new ResponseCurrencyDTO("base", 0, new ExchangeRatesDTO(1.1f)), null, 200));
        when(variables.getCurrencyAccessKey()).thenReturn("getCurrencyAccessKeyResponse");

        ResponseCurrencyDTO result = currencyInfoApiServiceImpl.searchCurrencyInfo("baseCurrency", "targetCurrency");
        Assertions.assertTrue(result.getExchangeRatesDTO().getUsd()>0f);
    }

    @Test
    void testSearchCurrencyInfoBad() {
        when(currencyInfoAdapterFeign.getCurrencyInfo(anyString(), anyString(), anyString())).thenThrow(FeignException.class);
        when(variables.getCurrencyAccessKey()).thenReturn("getCurrencyAccessKeyResponse");

        ResponseCurrencyDTO result = currencyInfoApiServiceImpl.searchCurrencyInfo("baseCurrency", "targetCurrency");
        Assertions.assertEquals("baseCurrency", result.getBase());
    }
}


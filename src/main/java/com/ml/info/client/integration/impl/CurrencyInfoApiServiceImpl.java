package com.ml.info.client.integration.impl;

import com.ml.info.client.adapter.CurrencyInfoAdapterFeign;
import com.ml.info.client.dto.currencyinfo.ExchangeRatesDTO;
import com.ml.info.client.dto.currencyinfo.ResponseCurrencyDTO;
import com.ml.info.client.integration.CurrencyInfoApiService;
import com.ml.info.config.EnvironmentVariables;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Implementacion Api Service Currency Info
 */
@Service
@RequiredArgsConstructor
public class CurrencyInfoApiServiceImpl implements CurrencyInfoApiService {
    private final CurrencyInfoAdapterFeign currencyInfoAdapterFeign;
    private final EnvironmentVariables variables;

    @Override
    public ResponseCurrencyDTO searchCurrencyInfo(String baseCurrency, String targetCurrency) {
        try {
            ResponseEntity<ResponseCurrencyDTO> currencyInfo = currencyInfoAdapterFeign.getCurrencyInfo(variables.getCurrencyAccessKey(), baseCurrency, targetCurrency);
            return currencyInfo.getBody();
        }catch (FeignException exception){
            return ResponseCurrencyDTO.builder().base(baseCurrency).exchangeRatesDTO(ExchangeRatesDTO.builder().build()).build();
        }
    }
}

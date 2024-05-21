package com.ml.info.client.integration;

import com.ml.info.client.dto.currencyinfo.ResponseCurrencyDTO;

/**
 * Interfaz Currency Info Api Service
 */
public interface CurrencyInfoApiService {

    ResponseCurrencyDTO searchCurrencyInfo(String baseCurrency, String targetCurrency);
}

package com.ml.info.client.integration;

import com.ml.info.client.dto.countryinfo.ResponseCountryInfoDTO;

/**
 * Interfaz Country Info Api Service
 */
public interface CountryInfoApiService {

    ResponseCountryInfoDTO searchCountryInfo(String ip);
}

package com.ml.info.client.integration.impl;

import com.ml.info.client.adapter.CountryInfoAdapterFeign;
import com.ml.info.client.dto.countryinfo.ResponseCountryInfoDTO;
import com.ml.info.client.integration.CountryInfoApiService;
import com.ml.info.config.EnvironmentVariables;
import com.ml.info.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Implementacion Api Service Country Info
 */
@Service
@RequiredArgsConstructor
public class CountryInfoApiServiceImpl implements CountryInfoApiService {
    private final CountryInfoAdapterFeign countryInfoAdapterFeign;
    private final EnvironmentVariables variables;

    @Override
    public ResponseCountryInfoDTO searchCountryInfo(String ip) {
        ResponseEntity<ResponseCountryInfoDTO> countryInfoIp = countryInfoAdapterFeign.getCountryInfoIp(variables.getCountryAccessKey(), ip, Constants.SERVICE_CONFIG_CLIENT_FILTER_COUNTRYINFO);
        return countryInfoIp.getBody();
    }
}

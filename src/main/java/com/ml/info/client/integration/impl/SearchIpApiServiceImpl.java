package com.ml.info.client.integration.impl;

import com.ml.info.client.adapter.SearchIpAdapterFeign;
import com.ml.info.client.dto.searchip.ResponseSearchIpDTO;
import com.ml.info.client.integration.SearchIpApiService;
import com.ml.info.config.EnvironmentVariables;
import com.ml.info.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Implementacion Api Service Search IP
 */
@Service
@RequiredArgsConstructor
public class SearchIpApiServiceImpl implements SearchIpApiService {

    private final SearchIpAdapterFeign searchIpAdapterFeign;
    private final EnvironmentVariables variables;

    @Override
    public ResponseSearchIpDTO searchInfoIp(String ip) {
        ResponseEntity<ResponseSearchIpDTO> searchInfoIp = searchIpAdapterFeign.getSearchInfoIp(ip, variables.getSearchIpAccessKey(), Constants.SERVICE_CONFIG_CLIENT_FILTER_SEARCHIP);
        return searchInfoIp.getBody();
    }
}

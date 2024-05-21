package com.ml.info.client.integration;

import com.ml.info.client.dto.searchip.ResponseSearchIpDTO;

/**
 * Interfaz Search IP Api Service
 */
public interface SearchIpApiService {

    ResponseSearchIpDTO searchInfoIp(String ip);
}

package com.ml.info.client.adapter;

import com.ml.info.client.dto.countryinfo.ResponseCountryInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign adapter Country Info
 */
@FeignClient(name = "${service.config.feign.client.countryinfo.name}",
        url = "${service.config.feign.client.countryinfo.url}")
public interface CountryInfoAdapterFeign {

    @GetMapping("/v1/")
    ResponseEntity<ResponseCountryInfoDTO> getCountryInfoIp(@RequestParam("api_key") String accessKey,@RequestParam("ip_address") String ip, @RequestParam("fields") String field);
}
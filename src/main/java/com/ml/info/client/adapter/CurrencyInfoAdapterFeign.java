package com.ml.info.client.adapter;

import com.ml.info.client.dto.currencyinfo.ResponseCurrencyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign adapter Currency Info
 */
@FeignClient(name = "${service.config.feign.client.currencyinfo.name}",
        url = "${service.config.feign.client.currencyinfo.url}")
public interface CurrencyInfoAdapterFeign {

    @GetMapping("/v1/live/")
    ResponseEntity<ResponseCurrencyDTO> getCurrencyInfo(@RequestParam("api_key") String accessKey,@RequestParam("base") String baseCurrency,@RequestParam("target") String targetCurrency);
}
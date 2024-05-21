package com.ml.info.client.adapter;

import com.ml.info.client.dto.searchip.ResponseSearchIpDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign adapter Search IP
 */
@FeignClient(name = "${service.config.feign.client.searchip.name}",
                url = "${service.config.feign.client.searchip.url}")
public interface SearchIpAdapterFeign {

    @GetMapping("/{ip}")
    ResponseEntity<ResponseSearchIpDTO> getSearchInfoIp(@PathVariable("ip") String ip, @RequestParam("access_key") String accessKey,@RequestParam("fields") String fields);
}

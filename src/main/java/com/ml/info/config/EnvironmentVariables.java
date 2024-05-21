package com.ml.info.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Config Class ENV
 */
@Getter
@Configuration
public class EnvironmentVariables {

    @Value("${service.config.value.searchip.accesskey}")
    private String searchIpAccessKey;

    @Value("${service.config.value.countryinfo.accesskey}")
    private String countryAccessKey;

    @Value("${service.config.value.currencyinfo.accesskey}")
    private String currencyAccessKey;
}

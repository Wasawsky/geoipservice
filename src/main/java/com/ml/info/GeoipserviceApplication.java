package com.ml.info;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Main Class
 */
@SpringBootApplication
@EnableFeignClients
public class GeoipserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoipserviceApplication.class, args);
	}

}

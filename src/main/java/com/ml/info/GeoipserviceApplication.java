package com.ml.info;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Main Class
 */
@OpenAPIDefinition(
		info = @Info(title = "Servicio Geolocalizacion IP",
				description = "Desafio tecnico"
		, version = "1.0.0")
)
@SpringBootApplication
@EnableFeignClients
public class GeoipserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoipserviceApplication.class, args);
	}

}

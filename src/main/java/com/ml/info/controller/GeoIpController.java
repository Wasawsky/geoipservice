package com.ml.info.controller;

import com.ml.info.exception.CustomException;
import com.ml.info.model.ResponseInfo;
import com.ml.info.service.GeoIpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "${service.config.controller.base.path}")
@RequiredArgsConstructor
@Tag(name = "Geolocalizacion de IP", description = "Servicio que se conecta con apis publicas para traer la informacion de una IP.")
public class GeoIpController {

    private final GeoIpService geoIpService;

    @Operation(summary = "Operacion Localizar IP")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(examples = {
                            @ExampleObject(name = "Servicio pudo conectarse a las APIS correctamente",
                                    summary = "Exito peticion",
                                    value = "{\"IP\":\"125.3.2.3\",\"Fecha actual\":\"21/05/2024 09:24:07 AM\",\"País\":\"Japan\",\"ISO Code\":\"JP\",\"Moneda\":\"1 JPY = 0.006417 USD\",\"Hora\":\"21/05/2024 23:24:07 PM\",\"Distancia estimada\":\"17850.34 kms  (-34.0, -64.0) a (35.6897, 139.6895)\"}")})
            }, description = "OK"),
            @ApiResponse(responseCode = "400", content = {
                    @Content(examples = {
                            @ExampleObject(name = "Servicio no pudo procesar la peticion",
                                    summary = "Fallo peticion",
                                    value = "{\"Code\":\"400\",\"Message\":\"Invalid request\",\"Status\":\"BadRequest\"}")})
            }, description = "Error bad request"),
            @ApiResponse(responseCode = "500", content = {
                    @Content(examples = {
                            @ExampleObject(name = "Servicio no pudo procesar la peticion",
                                    summary = "Fallo peticion",
                                    value = "{\"Code\":\"500\",\"Message\":\"[400 Bad Request] during [GET] to [https://ipgeolocation.abstractapi.com/v1/?api_key=f53423a033834e739147444f896c36b7&ip_address=1.2.3.&fields=currency%2Ctimezone%2Ccountry_code%2Ccountry%2Clongitude%2Clatitude] [CountryInfoAdapterFeign#getCountryInfoIp(String,String,String)]: [{\\\"error\\\":{\\\"message\\\":\\\"A validation error occurred.\\\",\\\"code\\\":\\\"validation_error\\\",\\\"details\\\":{\\\"ip_address\\\":[\\\"Invalid IP Address.\\\"]}}}]\",\"Status\":\"Error\"}")})
            }, description = "Error")
    })
    @PostMapping(path = "/localizar/ip", consumes = {MediaType.TEXT_PLAIN_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseInfo> postLocateIp(@RequestBody String value){
        if (value==null || value.isBlank()){
            throw new CustomException("400","Invalid request", List.of());
        }
        ResponseInfo responseInfo = geoIpService.requestInfoIP(value);
        return ResponseEntity.ok(responseInfo);
    }

    @Operation(summary = "Estadistica trafico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(examples = {
                            @ExampleObject(name = "Servicio informa el trafico",
                                    summary = "Exito peticion",
                                    value = "Distancia Promedio: 8460.465\n" +
                                            "Distancia mas cercana a Buenos Aires: 749.88\n" +
                                            "Distancia mas lejana a Buenos Aires: 16171.05")})
            }, description = "OK")
    })
    @GetMapping(path = "/obtener/estadistica",produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> getEstadistica(){
        return ResponseEntity.ok(geoIpService.getStatisticMachine());
    }
}

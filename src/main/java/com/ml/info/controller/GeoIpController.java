package com.ml.info.controller;

import com.ml.info.model.ResponseInfo;
import com.ml.info.service.GeoIpService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "${service.config.controller.base.path}")
@RequiredArgsConstructor
@Tag(name = "Geo IP API", description = "description")
public class GeoIpController {

    private final GeoIpService geoIpService;

    @Operation(summary = "Localizar IP")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD")
    })
    @PostMapping(path = "/localizar/ip", consumes = {MediaType.TEXT_PLAIN_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseInfo> postLocateIp(@RequestBody String value){
        log.info(value);
        ResponseInfo responseInfo = geoIpService.requestInfoIP(value);
        return ResponseEntity.ok(responseInfo);
    }

    @Operation(summary = "Localizar IP")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD")
    })
    @GetMapping(path = "/obtener/estadistica",produces = {MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> getEstadistica(){
        return ResponseEntity.ok(geoIpService.getStatisticMachine());
    }
}

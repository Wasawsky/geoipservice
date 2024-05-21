package com.ml.info.controller;

import com.ml.info.exception.CustomException;
import com.ml.info.model.ResponseInfo;
import com.ml.info.service.GeoIpService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GeoIpControllerTest {
    @Mock
    GeoIpService geoIpService;
    @InjectMocks
    GeoIpController geoIpController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        geoIpController = new GeoIpController(geoIpService);
    }

    @Test
    void testPostLocateIp() {
        when(geoIpService.requestInfoIP(anyString())).thenReturn(ResponseInfo.builder().ip("8.8.8.8").build());

        ResponseEntity<ResponseInfo> result = geoIpController.postLocateIp("8.8.8.8");
        Assertions.assertEquals("8.8.8.8", Objects.requireNonNull(result.getBody()).getIp());
    }

    @Test
    void testPostLocateIpBAD() {
        Assertions.assertThrows(CustomException.class , () ->geoIpController.postLocateIp("  "));
    }

    @Test
    void testPostLocateIpBAD2() {
        Assertions.assertThrows(CustomException.class , () ->geoIpController.postLocateIp(null));
    }


    @Test
    void testGetEstadistica() {
        when(geoIpService.getStatisticMachine()).thenReturn("getStatisticMachineResponse");

        ResponseEntity<String> result = geoIpController.getEstadistica();
        Assertions.assertTrue(!Objects.requireNonNull(result.getBody()).isEmpty());
    }
}


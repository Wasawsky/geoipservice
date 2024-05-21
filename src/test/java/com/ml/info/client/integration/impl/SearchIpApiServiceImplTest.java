package com.ml.info.client.integration.impl;

import com.ml.info.client.adapter.SearchIpAdapterFeign;
import com.ml.info.client.dto.searchip.LanguageDTO;
import com.ml.info.client.dto.searchip.LocationDTO;
import com.ml.info.client.dto.searchip.ResponseSearchIpDTO;
import com.ml.info.config.EnvironmentVariables;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SearchIpApiServiceImplTest {
    @Mock
    SearchIpAdapterFeign searchIpAdapterFeign;
    @Mock
    EnvironmentVariables variables;
    @InjectMocks
    SearchIpApiServiceImpl searchIpApiServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        searchIpApiServiceImpl = new SearchIpApiServiceImpl(searchIpAdapterFeign,variables);
    }

    @Test
    void testSearchInfoIp() {
        when(searchIpAdapterFeign.getSearchInfoIp(anyString(), anyString(), anyString())).thenReturn(new ResponseEntity<ResponseSearchIpDTO>(new ResponseSearchIpDTO(new LocationDTO(List.of(new LanguageDTO("code", "name", "attNative"))), 1.1f, 1.1f), null, 200));
        when(variables.getSearchIpAccessKey()).thenReturn("getSearchIpAccessKeyResponse");

        ResponseSearchIpDTO result = searchIpApiServiceImpl.searchInfoIp("ip");
        Assertions.assertTrue(result.getLatitude()>0);
    }
}


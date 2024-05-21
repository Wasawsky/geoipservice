package com.ml.info.util;

import com.ml.info.client.dto.searchip.LanguageDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class MapperServiceTest {
    MapperService mapperService = new MapperService();

    @Test
    void testMapLanguages() {
        String result = mapperService.mapLanguages(List.of(new LanguageDTO("code", "name", "attNative")));
        Assertions.assertFalse(result.isEmpty());
    }
}


package com.ml.info.util;

import com.ml.info.client.dto.searchip.LanguageDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Utilitario mapper
 */
@Component
public class MapperService {

    /**
     * Adjuntar valores de Array Language
     * @param languageDTOS lenguajes
     * @return String con la lista de lenguajes
     */
    public final String mapLanguages (List<LanguageDTO> languageDTOS){
        return languageDTOS.stream()
                .map(LanguageDTO::toStringLanguage)
                .collect(Collectors.joining(", "));
    }
}

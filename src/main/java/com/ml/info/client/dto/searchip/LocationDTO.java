
package com.ml.info.client.dto.searchip;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.util.List;

/**
 * Model Location DTO
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "languages"
})
public class LocationDTO {
    @JsonProperty("languages")
    private List<LanguageDTO> languageDTOS;

}


package com.ml.info.client.dto.countryinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

/**
 * Model Timezone DTO
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "abbreviation",
    "gmt_offset",
    "current_time",
    "is_dst"
})
public class TimezoneDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("abbreviation")
    private String abbreviation;
    @JsonProperty("gmt_offset")
    private Integer gmtOffset;
    @JsonProperty("current_time")
    private String currentTime;
    @JsonProperty("is_dst")
    private Boolean isDst;

}

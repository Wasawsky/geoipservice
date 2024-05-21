
package com.ml.info.client.dto.searchip;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

/**
 * Model Response Search IP DTO
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "latitude",
    "longitude",
    "location"
})
public class ResponseSearchIpDTO {

    @JsonProperty("location")
    private LocationDTO location;
    @JsonProperty("latitude")
    private Float latitude;
    @JsonProperty("longitude")
    private Float longitude;

}

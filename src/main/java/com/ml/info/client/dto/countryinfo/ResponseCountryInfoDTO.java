
package com.ml.info.client.dto.countryinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

/**
 * Model Response Country Info DTO
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "country",
    "country_code",
    "timezone",
    "currency",
        "latitude",
        "longitude"
})
public class ResponseCountryInfoDTO {

    @JsonProperty("country")
    private String country;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("timezone")
    private TimezoneDTO timezoneDTO;
    @JsonProperty("currency")
    private CurrencyDTO currencyDTO;
    @JsonProperty("latitude")
    private Float latitude;
    @JsonProperty("longitude")
    private Float longitude;

}

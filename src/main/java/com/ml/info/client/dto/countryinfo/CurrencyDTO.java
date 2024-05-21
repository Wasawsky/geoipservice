
package com.ml.info.client.dto.countryinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

/**
 * Model Currency DTO
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "currency_name",
    "currency_code"
})
public class CurrencyDTO {

    @JsonProperty("currency_name")
    private String currencyName;
    @JsonProperty("currency_code")
    private String currencyCode;

}


package com.ml.info.client.dto.currencyinfo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ml.info.util.Constants;
import lombok.*;

/**
 * Model Response Currency DTO
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "base",
    "last_updated",
    "exchange_rates"
})
public class ResponseCurrencyDTO {

    @JsonProperty("base")
    private String base;
    @JsonProperty("last_updated")
    private Integer lastUpdated;
    @JsonProperty("exchange_rates")
    private ExchangeRatesDTO exchangeRatesDTO;

    public String toStringUsd(){
        Float usd = exchangeRatesDTO.getUsd();
        if (usd!=null){
            return "1 " + base + " = " + usd + " " +Constants.BUSINESS_TARGETED_EXCHANGE;
        }else {
            return base + " | Oops! Exchange USD not found";
        }
    }

}

package com.ml.info.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Model Info Statistic
 */
@Getter
@Setter
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "nombrePML",
        "distanciaPML",
        "invocacionesPML",
        "nombrePMC",
        "distanciaPMC",
        "invocacionesPMC"
})
public class InfoStatistic {

    @JsonProperty("nombrePML")
    private String nombrePML;
    @JsonProperty("distanciaPML")
    private double distanciaPML;
    @JsonProperty("invocacionesPML")
    private int invocacionesPML;
    @JsonProperty("nombrePMC")
    private String nombrePMC;
    @JsonProperty("distanciaPMC")
    private double distanciaPMC;
    @JsonProperty("invocacionesPMC")
    private int invocacionesPMC;

}
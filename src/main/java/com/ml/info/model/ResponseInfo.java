package com.ml.info.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "IP",
        "Fecha actual",
        "País",
        "ISO Code",
        "Idiomas",
        "Moneda",
        "Hora",
        "Distancia estimada"
})
public class ResponseInfo {
    @JsonProperty("IP")
    private String ip;
    @JsonProperty("Fecha actual")
    private String fechaactual;
    @JsonProperty("País")
    private String pais;
    @JsonProperty("ISO Code")
    private String iSOCode;
    @JsonProperty("Idiomas")
    private String idiomas;
    @JsonProperty("Moneda")
    private String moneda;
    @JsonProperty("Hora")
    private String hora;
    @JsonProperty("Distancia estimada")
    private String distanciaestimada;

}
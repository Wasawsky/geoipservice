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
    public String ip;
    @JsonProperty("Fecha actual")
    public String fechaactual;
    @JsonProperty("País")
    public String pais;
    @JsonProperty("ISO Code")
    public String iSOCode;
    @JsonProperty("Idiomas")
    public String idiomas;
    @JsonProperty("Moneda")
    public String moneda;
    @JsonProperty("Hora")
    public String hora;
    @JsonProperty("Distancia estimada")
    public String distanciaestimada;

}
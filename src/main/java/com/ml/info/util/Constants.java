package com.ml.info.util;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

/**
 * Constants Class
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    /**
     * Config service
     */
    public static final String SERVICE_CONFIG_CLIENT_FILTER_SEARCHIP = "latitude,longitude,location.languages";
    public static final String SERVICE_CONFIG_CLIENT_FILTER_COUNTRYINFO = "currency,timezone,country_code,country,longitude,latitude";
    public static final String SERVICE_CONFIG_FORMAT_DATE = "dd/MM/yyyy HH:mm:ss a";

    /**
     * Business
     */
    public static final String BUSINESS_TARGETED_EXCHANGE = "USD";
    public static final double BUSINESS_CALCULATE_DISTANCE_VALUE_RADIUS = 6371;
    public static final double BUSINESS_CALCULATE_DISTANCE_VALUE_ARG_LONG = -64;
    public static final double BUSINESS_CALCULATE_DISTANCE_VALUE_ARG_LAT = -34;

    public static final String BUSINESS_MESSAGE_DISTANCIA_PROMEDIO = "Distancia Promedio: ";
    public static final String BUSINESS_MESSAGE_DISTANCIA_MAS_CERCANA_A_BUENOS_AIRES = "Distancia mas cercana a Buenos Aires: ";
    public static final String BUSINESS_MESSAGE_DISTANCIA_MAS_LEJANA_A_BUENOS_AIRES = "Distancia mas lejana a Buenos Aires: ";
    public static final String BUSINESS_MESSAGE_SIN_TRAFICO = "Sin Trafico";
}

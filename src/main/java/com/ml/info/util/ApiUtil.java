package com.ml.info.util;


import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static com.ml.info.util.Constants.SERVICE_CONFIG_FORMAT_DATE;

/**
 * Utilitarios
 */
@Component
public class ApiUtil {

    /**
     * Metodo que implementa la funcion matematica (Haversine)
     * Calcula la distancia entre 2 puntos en una esfera trayendo los valores correspondientes al planeta
     * @param lat1 latitud 1
     * @param lon1 longitud 1
     * @param lat2 latitud 2
     * @param lon2 longitud 2
     * @return Valor de la funcion calculado acotado a 2 decimales.
     */
    public static String distanceBetween(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double v = Constants.BUSINESS_CALCULATE_DISTANCE_VALUE_RADIUS * c;
        DecimalFormat formatter = new DecimalFormat("#0.00");
        return String.valueOf(formatter.format(v));
    }

    /**
     * Obtener fecha del sitio consultado
     * @param incomingDate zona horaria
     * @return Fecha con el formato aplicado
     */
    public String getArgZoneDate(String incomingDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(SERVICE_CONFIG_FORMAT_DATE);
        ZonedDateTime inEst = ZonedDateTime.now(ZoneId.of(incomingDate));
        return inEst.format(formatter);
    }

    /**
     * Obtiene la fecha actual con zona horaria en bogota
     * @return Fecha con el formato aplicado
     */
    public String getZonedDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(SERVICE_CONFIG_FORMAT_DATE);
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("America/Bogota") );
        return now.format(formatter);
    }
}

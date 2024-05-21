package com.ml.info.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ApiUtilTest {
    ApiUtil apiUtil = new ApiUtil();

    @Test
    void testDistanceBetween() {
        String result = ApiUtil.distanceBetween(0d, 0d, 0d, 0d);
        Assertions.assertEquals("0.00", result);
    }

    @Test
    void testGetArgZoneDate() {
        String result = apiUtil.getArgZoneDate("America/Bogota");
        Assertions.assertNotNull(result);
    }

    @Test
    void testGetZonedDate() {
        String result = apiUtil.getZonedDate();
        Assertions.assertNotNull(result);
    }
}


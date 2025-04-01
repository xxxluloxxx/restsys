package com.restaurant.restsys.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeUtil {
    private static final ZoneId ZONE_ID = ZoneId.of("America/Guayaquil");

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now(ZONE_ID);
    }
}
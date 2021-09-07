package org.example.spring.avro.util;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Objects;

public class DateUtil {

    public static LocalDate getLocalDate(Timestamp datetime) {
        return Objects.isNull(datetime) ? null : datetime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static Instant getInstant(Timestamp datetime) {
        return Objects.isNull(datetime) ? null : datetime.toInstant();
    }

    public static LocalDate getLocalDate(java.util.Date date) {
        return Objects.isNull(date) ? null : Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}

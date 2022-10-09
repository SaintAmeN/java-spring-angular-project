package com.project.spring.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Paweł Recław, AmeN
 * @project backend
 * @created 09.10.2022
 */
class TestDatePlusTime {
    @Test
    void testCreateLocalDateTimeFromDateAndTime() {
        LocalDate date = LocalDate.of(2022, 03, 15);
        LocalTime time = LocalTime.of(13, 01, 23);

        LocalDateTime result = date.atTime(time);
    }
}

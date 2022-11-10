package com.formacion.BS7_2.person.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class PersonTest {
    /**
     * Method under test: {@link Person#Person(String, String, String, String, String, String, String, Boolean, Date, String, Date)}
     */
    @Test
    void testConstructor() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        Person actualPerson = new Person("janedoe", "iloveyou", "Name", "Doe", "jane.doe@example.org",
                "jane.doe@example.org", "Oxford", true, fromResult, "https://example.org/example", fromResult1);

        assertTrue(actualPerson.getActive());
        assertEquals("janedoe", actualPerson.getUsername());
        assertSame(fromResult1, actualPerson.getTermination_date());
        assertEquals("Doe", actualPerson.getSurname());
        assertEquals("jane.doe@example.org", actualPerson.getPersonal_email());
        assertEquals("iloveyou", actualPerson.getPassword());
        assertEquals("Name", actualPerson.getName());
        assertEquals("https://example.org/example", actualPerson.getImage_url());
        assertNull(actualPerson.getId_person());
        assertSame(fromResult, actualPerson.getCreated_date());
        assertEquals("jane.doe@example.org", actualPerson.getCompany_email());
        assertEquals("Oxford", actualPerson.getCity());
    }
}


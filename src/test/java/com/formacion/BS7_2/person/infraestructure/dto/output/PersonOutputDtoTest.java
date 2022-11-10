package com.formacion.BS7_2.person.infraestructure.dto.output;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import com.formacion.BS7_2.person.domain.model.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

class PersonOutputDtoTest {
    /**
     * Method under test: {@link PersonOutputDto#PersonOutputDto(Person)}
     */
    @Test
    void testConstructor() {
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        person.setCreated_date(fromResult);
        person.setId_person(1);
        person.setImage_url("https://example.org/example");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonal_email("jane.doe@example.org");
        person.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        person.setTermination_date(fromResult1);
        person.setUsername("janedoe");
        PersonOutputDto actualPersonOutputDto = new PersonOutputDto(person);
        assertTrue(actualPersonOutputDto.getActive());
        assertEquals("janedoe", actualPersonOutputDto.getUsername());
        assertSame(fromResult1, actualPersonOutputDto.getTermination_date());
        assertEquals("Doe", actualPersonOutputDto.getSurname());
        assertEquals("jane.doe@example.org", actualPersonOutputDto.getPersonal_email());
        assertEquals("iloveyou", actualPersonOutputDto.getPassword());
        assertEquals("Name", actualPersonOutputDto.getName());
        assertEquals("https://example.org/example", actualPersonOutputDto.getImage_url());
        assertEquals(1, actualPersonOutputDto.getId_person().intValue());
        assertSame(fromResult, actualPersonOutputDto.getCreated_date());
        assertEquals("jane.doe@example.org", actualPersonOutputDto.getCompany_email());
        assertEquals("Oxford", actualPersonOutputDto.getCity());
    }

    /**
     * Method under test: {@link PersonOutputDto#PersonOutputDto(Person)}
     */
    @Test
    void testConstructor2() {
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompany_email("jane.doe@example.org");
        person.setCreated_date(mock(java.sql.Date.class));
        person.setId_person(1);
        person.setImage_url("https://example.org/example");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonal_email("jane.doe@example.org");
        person.setSurname("Doe");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        java.util.Date fromResult = java.util.Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        person.setTermination_date(fromResult);
        person.setUsername("janedoe");
        PersonOutputDto actualPersonOutputDto = new PersonOutputDto(person);
        assertTrue(actualPersonOutputDto.getActive());
        assertEquals("janedoe", actualPersonOutputDto.getUsername());
        assertSame(fromResult, actualPersonOutputDto.getTermination_date());
        assertEquals("Doe", actualPersonOutputDto.getSurname());
        assertEquals("jane.doe@example.org", actualPersonOutputDto.getPersonal_email());
        assertEquals("iloveyou", actualPersonOutputDto.getPassword());
        assertEquals("Name", actualPersonOutputDto.getName());
        assertEquals("https://example.org/example", actualPersonOutputDto.getImage_url());
        assertEquals(1, actualPersonOutputDto.getId_person().intValue());
        assertEquals("jane.doe@example.org", actualPersonOutputDto.getCompany_email());
        assertEquals("Oxford", actualPersonOutputDto.getCity());
    }
}


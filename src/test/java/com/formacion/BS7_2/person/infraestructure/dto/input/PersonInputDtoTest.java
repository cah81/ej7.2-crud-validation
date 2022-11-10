package com.formacion.BS7_2.person.infraestructure.dto.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

import org.junit.jupiter.api.Test;

class PersonInputDtoTest {
    /**
     * Method under test: {@link PersonInputDto#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new PersonInputDto()).canEqual("Other"));
    }

    /**
     * Method under test: {@link PersonInputDto#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        PersonInputDto personInputDto = new PersonInputDto();

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertTrue(personInputDto.canEqual(personInputDto1));
    }

    /**
     * Method under test: {@link PersonInputDto#canEqual(Object)}
     */
    @Test
    void testCanEqual3() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setCreated_date(mock(java.sql.Date.class));
        assertFalse(personInputDto.canEqual("Other"));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link PersonInputDto}
     *   <li>{@link PersonInputDto#setActive(Boolean)}
     *   <li>{@link PersonInputDto#setCity(String)}
     *   <li>{@link PersonInputDto#setCompany_email(String)}
     *   <li>{@link PersonInputDto#setCreated_date(Date)}
     *   <li>{@link PersonInputDto#setId_person(Integer)}
     *   <li>{@link PersonInputDto#setImage_url(String)}
     *   <li>{@link PersonInputDto#setName(String)}
     *   <li>{@link PersonInputDto#setPassword(String)}
     *   <li>{@link PersonInputDto#setPersonal_email(String)}
     *   <li>{@link PersonInputDto#setSurname(String)}
     *   <li>{@link PersonInputDto#setTermination_date(Date)}
     *   <li>{@link PersonInputDto#setUsername(String)}
     *   <li>{@link PersonInputDto#toString()}
     *   <li>{@link PersonInputDto#getActive()}
     *   <li>{@link PersonInputDto#getCity()}
     *   <li>{@link PersonInputDto#getCompany_email()}
     *   <li>{@link PersonInputDto#getCreated_date()}
     *   <li>{@link PersonInputDto#getId_person()}
     *   <li>{@link PersonInputDto#getImage_url()}
     *   <li>{@link PersonInputDto#getName()}
     *   <li>{@link PersonInputDto#getPassword()}
     *   <li>{@link PersonInputDto#getPersonal_email()}
     *   <li>{@link PersonInputDto#getSurname()}
     *   <li>{@link PersonInputDto#getTermination_date()}
     *   <li>{@link PersonInputDto#getUsername()}
     * </ul>
     */
    @Test
    void testConstructor() {
        PersonInputDto actualPersonInputDto = new PersonInputDto();
        actualPersonInputDto.setActive(true);
        actualPersonInputDto.setCity("Oxford");
        actualPersonInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        actualPersonInputDto.setCreated_date(fromResult);
        actualPersonInputDto.setId_person(1);
        actualPersonInputDto.setImage_url("https://example.org/example");
        actualPersonInputDto.setName("Name");
        actualPersonInputDto.setPassword("iloveyou");
        actualPersonInputDto.setPersonal_email("jane.doe@example.org");
        actualPersonInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        actualPersonInputDto.setTermination_date(fromResult1);
        actualPersonInputDto.setUsername("janedoe");
        actualPersonInputDto.toString();
        assertTrue(actualPersonInputDto.getActive());
        assertEquals("Oxford", actualPersonInputDto.getCity());
        assertEquals("jane.doe@example.org", actualPersonInputDto.getCompany_email());
        assertSame(fromResult, actualPersonInputDto.getCreated_date());
        assertEquals(1, actualPersonInputDto.getId_person().intValue());
        assertEquals("https://example.org/example", actualPersonInputDto.getImage_url());
        assertEquals("Name", actualPersonInputDto.getName());
        assertEquals("iloveyou", actualPersonInputDto.getPassword());
        assertEquals("jane.doe@example.org", actualPersonInputDto.getPersonal_email());
        assertEquals("Doe", actualPersonInputDto.getSurname());
        assertSame(fromResult1, actualPersonInputDto.getTermination_date());
        assertEquals("janedoe", actualPersonInputDto.getUsername());
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");
        assertNotEquals(personInputDto, null);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals2() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");
        assertNotEquals(personInputDto, "Different type to PersonInputDto");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PersonInputDto#equals(Object)}
     *   <li>{@link PersonInputDto#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");
        assertEquals(personInputDto, personInputDto);
        int expectedHashCodeResult = personInputDto.hashCode();
        assertEquals(expectedHashCodeResult, personInputDto.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PersonInputDto#equals(Object)}
     *   <li>{@link PersonInputDto#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertEquals(personInputDto, personInputDto1);
        int expectedHashCodeResult = personInputDto.hashCode();
        assertEquals(expectedHashCodeResult, personInputDto1.hashCode());
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals5() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(false);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals6() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(null);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals7() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("janedoe");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals8() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity(null);
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals9() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("janedoe");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals10() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email(null);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals11() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneOffset.ofTotalSeconds(1)).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals12() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        personInputDto.setCreated_date(null);
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals13() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(3);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals14() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(null);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals15() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("janedoe");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals16() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url(null);
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals17() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("janedoe");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals18() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName(null);
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals19() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("janedoe");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals20() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword(null);
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals21() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("janedoe");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals22() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email(null);
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals23() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("janedoe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals24() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname(null);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals25() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto
                .setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneOffset.ofTotalSeconds(1)).toInstant()));
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals26() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        personInputDto.setTermination_date(null);
        personInputDto.setUsername("janedoe");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals27() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("iloveyou");

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }

    /**
     * Method under test: {@link PersonInputDto#equals(Object)}
     */
    @Test
    void testEquals28() {
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername(null);

        PersonInputDto personInputDto1 = new PersonInputDto();
        personInputDto1.setActive(true);
        personInputDto1.setCity("Oxford");
        personInputDto1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setId_person(1);
        personInputDto1.setImage_url("https://example.org/example");
        personInputDto1.setName("Name");
        personInputDto1.setPassword("iloveyou");
        personInputDto1.setPersonal_email("jane.doe@example.org");
        personInputDto1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto1.setUsername("janedoe");
        assertNotEquals(personInputDto, personInputDto1);
    }
}


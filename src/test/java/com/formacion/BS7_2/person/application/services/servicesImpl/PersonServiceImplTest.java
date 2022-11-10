package com.formacion.BS7_2.person.application.services.servicesImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.formacion.BS7_2.exception.EntityNotFoundException;
import com.formacion.BS7_2.exception.UnprocessableEntityException;
import com.formacion.BS7_2.person.domain.model.Person;
import com.formacion.BS7_2.person.infraestructure.dto.input.PersonInputDto;
import com.formacion.BS7_2.person.infraestructure.dto.output.PersonOutputDto;
import com.formacion.BS7_2.person.infraestructure.repository.PersonDaoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PersonServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PersonServiceImplTest {
    @MockBean
    private PersonDaoRepository personDaoRepository;

    @Autowired
    private PersonServiceImpl personServiceImpl;

    /**
     * Method under test: {@link PersonServiceImpl#addUser(PersonInputDto)}
     */
    @Test
    void testAddUser() throws Exception {
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId_person(1);
        person.setImage_url("https://example.org/example");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonal_email("jane.doe@example.org");
        person.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person.setUsername("janedoe");
        when(personDaoRepository.save((Person) any())).thenReturn(person);

        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant());
        personInputDto.setCreated_date(fromResult);
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant());
        personInputDto.setTermination_date(fromResult1);
        personInputDto.setUsername("janedoe");
        PersonOutputDto actualAddUserResult = personServiceImpl.addUser(personInputDto);
        assertTrue(actualAddUserResult.getActive());
        assertEquals("janedoe", actualAddUserResult.getUsername());
        assertSame(fromResult1, actualAddUserResult.getTermination_date());
        assertEquals("Doe", actualAddUserResult.getSurname());
        assertEquals("jane.doe@example.org", actualAddUserResult.getPersonal_email());
        assertEquals("iloveyou", actualAddUserResult.getPassword());
        assertEquals("Name", actualAddUserResult.getName());
        assertEquals("https://example.org/example", actualAddUserResult.getImage_url());
        assertNull(actualAddUserResult.getId_person());
        assertSame(fromResult, actualAddUserResult.getCreated_date());
        assertEquals("jane.doe@example.org", actualAddUserResult.getCompany_email());
        assertEquals("Oxford", actualAddUserResult.getCity());
        verify(personDaoRepository).save((Person) any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#addUser(PersonInputDto)}
     */
    @Test
    void testAddUser2() throws Exception {
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId_person(1);
        person.setImage_url("https://example.org/example");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonal_email("jane.doe@example.org");
        person.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person.setUsername("janedoe");
        when(personDaoRepository.save((Person) any())).thenReturn(person);
        PersonInputDto personInputDto = mock(PersonInputDto.class);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(personInputDto.getActive()).thenThrow(new UnprocessableEntityException("An error occurred", 1,
                Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant())));
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(personInputDto.getImage_url()).thenThrow(new UnprocessableEntityException("An error occurred", 1,
                Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant())));
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(personInputDto.getSurname()).thenThrow(new UnprocessableEntityException("An error occurred", 1,
                Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant())));
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(personInputDto.getCreated_date()).thenThrow(new UnprocessableEntityException("An error occurred", 1,
                Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant())));
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(personInputDto.getTermination_date()).thenThrow(new UnprocessableEntityException("An error occurred", 1,
                Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant())));
        when(personInputDto.getCity()).thenReturn("Oxford");
        when(personInputDto.getPersonal_email()).thenReturn("jane.doe@example.org");
        when(personInputDto.getCompany_email()).thenReturn("jane.doe@example.org");
        when(personInputDto.getName()).thenReturn("Name");
        when(personInputDto.getPassword()).thenReturn("iloveyou");
        when(personInputDto.getUsername()).thenReturn("janedoe");
        doNothing().when(personInputDto).setActive((Boolean) any());
        doNothing().when(personInputDto).setCity((String) any());
        doNothing().when(personInputDto).setCompany_email((String) any());
        doNothing().when(personInputDto).setCreated_date((Date) any());
        doNothing().when(personInputDto).setId_person((Integer) any());
        doNothing().when(personInputDto).setImage_url((String) any());
        doNothing().when(personInputDto).setName((String) any());
        doNothing().when(personInputDto).setPassword((String) any());
        doNothing().when(personInputDto).setPersonal_email((String) any());
        doNothing().when(personInputDto).setSurname((String) any());
        doNothing().when(personInputDto).setTermination_date((Date) any());
        doNothing().when(personInputDto).setUsername((String) any());
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult8 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult8.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");
        assertThrows(UnprocessableEntityException.class, () -> personServiceImpl.addUser(personInputDto));
        verify(personInputDto).getActive();
        verify(personInputDto).getCity();
        verify(personInputDto, atLeast(1)).getCompany_email();
        verify(personInputDto).getName();
        verify(personInputDto).getPassword();
        verify(personInputDto, atLeast(1)).getPersonal_email();
        verify(personInputDto, atLeast(1)).getUsername();
        verify(personInputDto).setActive((Boolean) any());
        verify(personInputDto).setCity((String) any());
        verify(personInputDto).setCompany_email((String) any());
        verify(personInputDto).setCreated_date((Date) any());
        verify(personInputDto).setId_person((Integer) any());
        verify(personInputDto).setImage_url((String) any());
        verify(personInputDto).setName((String) any());
        verify(personInputDto).setPassword((String) any());
        verify(personInputDto).setPersonal_email((String) any());
        verify(personInputDto).setSurname((String) any());
        verify(personInputDto).setTermination_date((Date) any());
        verify(personInputDto).setUsername((String) any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#findById(Integer)}
     */
    @Test
    void testFindById() throws Exception {
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
        Optional<Person> ofResult = Optional.of(person);
        when(personDaoRepository.findById((Integer) any())).thenReturn(ofResult);
        PersonOutputDto actualFindByIdResult = personServiceImpl.findById(1);
        assertTrue(actualFindByIdResult.getActive());
        assertEquals("janedoe", actualFindByIdResult.getUsername());
        assertSame(fromResult1, actualFindByIdResult.getTermination_date());
        assertEquals("Doe", actualFindByIdResult.getSurname());
        assertEquals("jane.doe@example.org", actualFindByIdResult.getPersonal_email());
        assertEquals("iloveyou", actualFindByIdResult.getPassword());
        assertEquals("Name", actualFindByIdResult.getName());
        assertEquals("https://example.org/example", actualFindByIdResult.getImage_url());
        assertEquals(1, actualFindByIdResult.getId_person().intValue());
        assertSame(fromResult, actualFindByIdResult.getCreated_date());
        assertEquals("jane.doe@example.org", actualFindByIdResult.getCompany_email());
        assertEquals("Oxford", actualFindByIdResult.getCity());
        verify(personDaoRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#findById(Integer)}
     */
    @Test
    void testFindById2() throws Exception {
        Person person = mock(Person.class);
        when(person.getActive()).thenReturn(true);
        when(person.getId_person()).thenReturn(1);
        when(person.getCity()).thenReturn("Oxford");
        when(person.getCompany_email()).thenReturn("jane.doe@example.org");
        when(person.getImage_url()).thenReturn("https://example.org/example");
        when(person.getName()).thenReturn("Name");
        when(person.getPassword()).thenReturn("iloveyou");
        when(person.getPersonal_email()).thenReturn("jane.doe@example.org");
        when(person.getSurname()).thenReturn("Doe");
        when(person.getUsername()).thenReturn("janedoe");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        when(person.getCreated_date()).thenReturn(fromResult);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        when(person.getTermination_date()).thenReturn(fromResult1);
        doNothing().when(person).setActive((Boolean) any());
        doNothing().when(person).setCity((String) any());
        doNothing().when(person).setCompany_email((String) any());
        doNothing().when(person).setCreated_date((Date) any());
        doNothing().when(person).setId_person((Integer) any());
        doNothing().when(person).setImage_url((String) any());
        doNothing().when(person).setName((String) any());
        doNothing().when(person).setPassword((String) any());
        doNothing().when(person).setPersonal_email((String) any());
        doNothing().when(person).setSurname((String) any());
        doNothing().when(person).setTermination_date((Date) any());
        doNothing().when(person).setUsername((String) any());
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId_person(1);
        person.setImage_url("https://example.org/example");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonal_email("jane.doe@example.org");
        person.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        person.setUsername("janedoe");
        Optional<Person> ofResult = Optional.of(person);
        when(personDaoRepository.findById((Integer) any())).thenReturn(ofResult);
        PersonOutputDto actualFindByIdResult = personServiceImpl.findById(1);
        assertTrue(actualFindByIdResult.getActive());
        assertEquals("janedoe", actualFindByIdResult.getUsername());
        assertSame(fromResult1, actualFindByIdResult.getTermination_date());
        assertEquals("Doe", actualFindByIdResult.getSurname());
        assertEquals("jane.doe@example.org", actualFindByIdResult.getPersonal_email());
        assertEquals("iloveyou", actualFindByIdResult.getPassword());
        assertEquals("Name", actualFindByIdResult.getName());
        assertEquals("https://example.org/example", actualFindByIdResult.getImage_url());
        assertEquals(1, actualFindByIdResult.getId_person().intValue());
        assertSame(fromResult, actualFindByIdResult.getCreated_date());
        assertEquals("jane.doe@example.org", actualFindByIdResult.getCompany_email());
        assertEquals("Oxford", actualFindByIdResult.getCity());
        verify(personDaoRepository).findById((Integer) any());
        verify(person).getActive();
        verify(person).getId_person();
        verify(person).getCity();
        verify(person).getCompany_email();
        verify(person).getImage_url();
        verify(person).getName();
        verify(person).getPassword();
        verify(person).getPersonal_email();
        verify(person).getSurname();
        verify(person).getUsername();
        verify(person).getCreated_date();
        verify(person).getTermination_date();
        verify(person).setActive((Boolean) any());
        verify(person).setCity((String) any());
        verify(person).setCompany_email((String) any());
        verify(person).setCreated_date((Date) any());
        verify(person).setId_person((Integer) any());
        verify(person).setImage_url((String) any());
        verify(person).setName((String) any());
        verify(person).setPassword((String) any());
        verify(person).setPersonal_email((String) any());
        verify(person).setSurname((String) any());
        verify(person).setTermination_date((Date) any());
        verify(person).setUsername((String) any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#findById(Integer)}
     */
    @Test
    void testFindById3() throws Exception {
        when(personDaoRepository.findById((Integer) any())).thenReturn(Optional.empty());
        Person person = mock(Person.class);
        when(person.getActive()).thenReturn(true);
        when(person.getId_person()).thenReturn(1);
        when(person.getCity()).thenReturn("Oxford");
        when(person.getCompany_email()).thenReturn("jane.doe@example.org");
        when(person.getImage_url()).thenReturn("https://example.org/example");
        when(person.getName()).thenReturn("Name");
        when(person.getPassword()).thenReturn("iloveyou");
        when(person.getPersonal_email()).thenReturn("jane.doe@example.org");
        when(person.getSurname()).thenReturn("Doe");
        when(person.getUsername()).thenReturn("janedoe");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(person.getCreated_date()).thenReturn(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(person.getTermination_date())
                .thenReturn(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        doNothing().when(person).setActive((Boolean) any());
        doNothing().when(person).setCity((String) any());
        doNothing().when(person).setCompany_email((String) any());
        doNothing().when(person).setCreated_date((Date) any());
        doNothing().when(person).setId_person((Integer) any());
        doNothing().when(person).setImage_url((String) any());
        doNothing().when(person).setName((String) any());
        doNothing().when(person).setPassword((String) any());
        doNothing().when(person).setPersonal_email((String) any());
        doNothing().when(person).setSurname((String) any());
        doNothing().when(person).setTermination_date((Date) any());
        doNothing().when(person).setUsername((String) any());
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId_person(1);
        person.setImage_url("https://example.org/example");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonal_email("jane.doe@example.org");
        person.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        person.setUsername("janedoe");
        assertThrows(EntityNotFoundException.class, () -> personServiceImpl.findById(1));
        verify(personDaoRepository).findById((Integer) any());
        verify(person).setActive((Boolean) any());
        verify(person).setCity((String) any());
        verify(person).setCompany_email((String) any());
        verify(person).setCreated_date((Date) any());
        verify(person).setId_person((Integer) any());
        verify(person).setImage_url((String) any());
        verify(person).setName((String) any());
        verify(person).setPassword((String) any());
        verify(person).setPersonal_email((String) any());
        verify(person).setSurname((String) any());
        verify(person).setTermination_date((Date) any());
        verify(person).setUsername((String) any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#findByName(String)}
     */
    @Test
    void testFindByName() throws Exception {
        when(personDaoRepository.findByUsername((String) any())).thenReturn(new ArrayList<>());
        assertThrows(EntityNotFoundException.class, () -> personServiceImpl.findByName("janedoe"));
        verify(personDaoRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#findByName(String)}
     */
    @Test
    void testFindByName2() throws Exception {
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId_person(1);
        person.setImage_url("https://example.org/example");
        person.setName("Person does not exist");
        person.setPassword("iloveyou");
        person.setPersonal_email("jane.doe@example.org");
        person.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person.setUsername("janedoe");

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(person);
        when(personDaoRepository.findByUsername((String) any())).thenReturn(personList);
        assertEquals(1, personServiceImpl.findByName("janedoe").size());
        verify(personDaoRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#findByName(String)}
     */
    @Test
    void testFindByName3() throws Exception {
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId_person(1);
        person.setImage_url("https://example.org/example");
        person.setName("Person does not exist");
        person.setPassword("iloveyou");
        person.setPersonal_email("jane.doe@example.org");
        person.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person.setUsername("janedoe");

        Person person1 = new Person();
        person1.setActive(true);
        person1.setCity("Oxford");
        person1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setId_person(1);
        person1.setImage_url("https://example.org/example");
        person1.setName("Name");
        person1.setPassword("iloveyou");
        person1.setPersonal_email("jane.doe@example.org");
        person1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setUsername("janedoe");

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person);
        when(personDaoRepository.findByUsername((String) any())).thenReturn(personList);
        assertEquals(2, personServiceImpl.findByName("janedoe").size());
        verify(personDaoRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#findByName(String)}
     */
    @Test
    void testFindByName4() throws Exception {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(personDaoRepository.findByUsername((String) any())).thenThrow(new EntityNotFoundException(
                "An error occurred", 1, Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant())));
        assertThrows(EntityNotFoundException.class, () -> personServiceImpl.findByName("janedoe"));
        verify(personDaoRepository).findByUsername((String) any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#findByName(String)}
     */
    @Test
    void testFindByName5() throws Exception {
        Person person = mock(Person.class);
        when(person.getActive()).thenReturn(true);
        when(person.getId_person()).thenReturn(1);
        when(person.getCity()).thenReturn("Oxford");
        when(person.getCompany_email()).thenReturn("jane.doe@example.org");
        when(person.getImage_url()).thenReturn("https://example.org/example");
        when(person.getName()).thenReturn("Name");
        when(person.getPassword()).thenReturn("iloveyou");
        when(person.getPersonal_email()).thenReturn("jane.doe@example.org");
        when(person.getSurname()).thenReturn("Doe");
        when(person.getUsername()).thenReturn("janedoe");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(person.getCreated_date()).thenReturn(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(person.getTermination_date())
                .thenReturn(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        doNothing().when(person).setActive((Boolean) any());
        doNothing().when(person).setCity((String) any());
        doNothing().when(person).setCompany_email((String) any());
        doNothing().when(person).setCreated_date((Date) any());
        doNothing().when(person).setId_person((Integer) any());
        doNothing().when(person).setImage_url((String) any());
        doNothing().when(person).setName((String) any());
        doNothing().when(person).setPassword((String) any());
        doNothing().when(person).setPersonal_email((String) any());
        doNothing().when(person).setSurname((String) any());
        doNothing().when(person).setTermination_date((Date) any());
        doNothing().when(person).setUsername((String) any());
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId_person(1);
        person.setImage_url("https://example.org/example");
        person.setName("Person does not exist");
        person.setPassword("iloveyou");
        person.setPersonal_email("jane.doe@example.org");
        person.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        person.setUsername("janedoe");

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(person);
        when(personDaoRepository.findByUsername((String) any())).thenReturn(personList);
        assertEquals(1, personServiceImpl.findByName("janedoe").size());
        verify(personDaoRepository).findByUsername((String) any());
        verify(person).getActive();
        verify(person).getId_person();
        verify(person).getCity();
        verify(person).getCompany_email();
        verify(person).getImage_url();
        verify(person).getName();
        verify(person).getPassword();
        verify(person).getPersonal_email();
        verify(person).getSurname();
        verify(person).getUsername();
        verify(person).getCreated_date();
        verify(person).getTermination_date();
        verify(person).setActive((Boolean) any());
        verify(person).setCity((String) any());
        verify(person).setCompany_email((String) any());
        verify(person).setCreated_date((Date) any());
        verify(person).setId_person((Integer) any());
        verify(person).setImage_url((String) any());
        verify(person).setName((String) any());
        verify(person).setPassword((String) any());
        verify(person).setPersonal_email((String) any());
        verify(person).setSurname((String) any());
        verify(person).setTermination_date((Date) any());
        verify(person).setUsername((String) any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#updateUser(Integer, PersonInputDto)}
     */
    @Test
    void testUpdateUser() throws Exception {
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
        Optional<Person> ofResult = Optional.of(person);

        Person person1 = new Person();
        person1.setActive(true);
        person1.setCity("Oxford");
        person1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setId_person(1);
        person1.setImage_url("https://example.org/example");
        person1.setName("Name");
        person1.setPassword("iloveyou");
        person1.setPersonal_email("jane.doe@example.org");
        person1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setUsername("janedoe");
        when(personDaoRepository.save((Person) any())).thenReturn(person1);
        when(personDaoRepository.findById((Integer) any())).thenReturn(ofResult);

        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");
        PersonOutputDto actualUpdateUserResult = personServiceImpl.updateUser(1, personInputDto);
        assertTrue(actualUpdateUserResult.getActive());
        assertEquals("janedoe", actualUpdateUserResult.getUsername());
        assertSame(fromResult1, actualUpdateUserResult.getTermination_date());
        assertEquals("Doe", actualUpdateUserResult.getSurname());
        assertEquals("jane.doe@example.org", actualUpdateUserResult.getPersonal_email());
        assertEquals("iloveyou", actualUpdateUserResult.getPassword());
        assertEquals("Name", actualUpdateUserResult.getName());
        assertEquals("https://example.org/example", actualUpdateUserResult.getImage_url());
        assertEquals(1, actualUpdateUserResult.getId_person().intValue());
        assertSame(fromResult, actualUpdateUserResult.getCreated_date());
        assertEquals("jane.doe@example.org", actualUpdateUserResult.getCompany_email());
        assertEquals("Oxford", actualUpdateUserResult.getCity());
        verify(personDaoRepository).save((Person) any());
        verify(personDaoRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#updateUser(Integer, PersonInputDto)}
     */
    @Test
    void testUpdateUser2() throws Exception {
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId_person(1);
        person.setImage_url("https://example.org/example");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonal_email("jane.doe@example.org");
        person.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person.setUsername("janedoe");
        Optional<Person> ofResult = Optional.of(person);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(personDaoRepository.save((Person) any())).thenThrow(new EntityNotFoundException("An error occurred", 10,
                Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant())));
        when(personDaoRepository.findById((Integer) any())).thenReturn(ofResult);

        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");
        assertThrows(EntityNotFoundException.class, () -> personServiceImpl.updateUser(1, personInputDto));
        verify(personDaoRepository).save((Person) any());
        verify(personDaoRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#updateUser(Integer, PersonInputDto)}
     */
    @Test
    void testUpdateUser3() throws Exception {
        Person person = mock(Person.class);
        when(person.getActive()).thenReturn(true);
        when(person.getId_person()).thenReturn(1);
        when(person.getCity()).thenReturn("Oxford");
        when(person.getCompany_email()).thenReturn("jane.doe@example.org");
        when(person.getImage_url()).thenReturn("https://example.org/example");
        when(person.getName()).thenReturn("Name");
        when(person.getPassword()).thenReturn("iloveyou");
        when(person.getPersonal_email()).thenReturn("jane.doe@example.org");
        when(person.getSurname()).thenReturn("Doe");
        when(person.getUsername()).thenReturn("janedoe");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());
        when(person.getCreated_date()).thenReturn(fromResult);
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult1 = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());
        when(person.getTermination_date()).thenReturn(fromResult1);
        doNothing().when(person).setActive((Boolean) any());
        doNothing().when(person).setCity((String) any());
        doNothing().when(person).setCompany_email((String) any());
        doNothing().when(person).setCreated_date((Date) any());
        doNothing().when(person).setId_person((Integer) any());
        doNothing().when(person).setImage_url((String) any());
        doNothing().when(person).setName((String) any());
        doNothing().when(person).setPassword((String) any());
        doNothing().when(person).setPersonal_email((String) any());
        doNothing().when(person).setSurname((String) any());
        doNothing().when(person).setTermination_date((Date) any());
        doNothing().when(person).setUsername((String) any());
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId_person(1);
        person.setImage_url("https://example.org/example");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonal_email("jane.doe@example.org");
        person.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        person.setUsername("janedoe");
        Optional<Person> ofResult = Optional.of(person);

        Person person1 = new Person();
        person1.setActive(true);
        person1.setCity("Oxford");
        person1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult4 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setCreated_date(Date.from(atStartOfDayResult4.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setId_person(1);
        person1.setImage_url("https://example.org/example");
        person1.setName("Name");
        person1.setPassword("iloveyou");
        person1.setPersonal_email("jane.doe@example.org");
        person1.setSurname("Doe");
        LocalDateTime atStartOfDayResult5 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setTermination_date(Date.from(atStartOfDayResult5.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setUsername("janedoe");
        when(personDaoRepository.save((Person) any())).thenReturn(person1);
        when(personDaoRepository.findById((Integer) any())).thenReturn(ofResult);

        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setActive(true);
        personInputDto.setCity("Oxford");
        personInputDto.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult6 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setCreated_date(Date.from(atStartOfDayResult6.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setId_person(1);
        personInputDto.setImage_url("https://example.org/example");
        personInputDto.setName("Name");
        personInputDto.setPassword("iloveyou");
        personInputDto.setPersonal_email("jane.doe@example.org");
        personInputDto.setSurname("Doe");
        LocalDateTime atStartOfDayResult7 = LocalDate.of(1970, 1, 1).atStartOfDay();
        personInputDto.setTermination_date(Date.from(atStartOfDayResult7.atZone(ZoneId.of("UTC")).toInstant()));
        personInputDto.setUsername("janedoe");
        PersonOutputDto actualUpdateUserResult = personServiceImpl.updateUser(1, personInputDto);
        assertTrue(actualUpdateUserResult.getActive());
        assertEquals("janedoe", actualUpdateUserResult.getUsername());
        assertSame(fromResult1, actualUpdateUserResult.getTermination_date());
        assertEquals("Doe", actualUpdateUserResult.getSurname());
        assertEquals("jane.doe@example.org", actualUpdateUserResult.getPersonal_email());
        assertEquals("iloveyou", actualUpdateUserResult.getPassword());
        assertEquals("Name", actualUpdateUserResult.getName());
        assertEquals("https://example.org/example", actualUpdateUserResult.getImage_url());
        assertEquals(1, actualUpdateUserResult.getId_person().intValue());
        assertSame(fromResult, actualUpdateUserResult.getCreated_date());
        assertEquals("jane.doe@example.org", actualUpdateUserResult.getCompany_email());
        assertEquals("Oxford", actualUpdateUserResult.getCity());
        verify(personDaoRepository).save((Person) any());
        verify(personDaoRepository).findById((Integer) any());
        verify(person).getActive();
        verify(person).getId_person();
        verify(person).getCity();
        verify(person).getCompany_email();
        verify(person).getImage_url();
        verify(person).getName();
        verify(person).getPassword();
        verify(person).getPersonal_email();
        verify(person).getSurname();
        verify(person).getUsername();
        verify(person).getCreated_date();
        verify(person).getTermination_date();
        verify(person, atLeast(1)).setActive((Boolean) any());
        verify(person, atLeast(1)).setCity((String) any());
        verify(person, atLeast(1)).setCompany_email((String) any());
        verify(person).setCreated_date((Date) any());
        verify(person).setId_person((Integer) any());
        verify(person, atLeast(1)).setImage_url((String) any());
        verify(person, atLeast(1)).setName((String) any());
        verify(person, atLeast(1)).setPassword((String) any());
        verify(person, atLeast(1)).setPersonal_email((String) any());
        verify(person, atLeast(1)).setSurname((String) any());
        verify(person).setTermination_date((Date) any());
        verify(person, atLeast(1)).setUsername((String) any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#deleteUser(Integer)}
     */
    @Test
    void testDeleteUser() throws Exception {
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId_person(1);
        person.setImage_url("https://example.org/example");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonal_email("jane.doe@example.org");
        person.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person.setUsername("janedoe");
        Optional<Person> ofResult = Optional.of(person);
        doNothing().when(personDaoRepository).delete((Person) any());
        when(personDaoRepository.findById((Integer) any())).thenReturn(ofResult);
        assertEquals("Person deleted", personServiceImpl.deleteUser(1));
        verify(personDaoRepository).findById((Integer) any());
        verify(personDaoRepository).delete((Person) any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#deleteUser(Integer)}
     */
    @Test
    void testDeleteUser2() throws Exception {
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId_person(1);
        person.setImage_url("https://example.org/example");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonal_email("jane.doe@example.org");
        person.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person.setUsername("janedoe");
        Optional<Person> ofResult = Optional.of(person);
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        doThrow(new EntityNotFoundException("An error occurred", 1,
                Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()))).when(personDaoRepository)
                .delete((Person) any());
        when(personDaoRepository.findById((Integer) any())).thenReturn(ofResult);
        assertThrows(EntityNotFoundException.class, () -> personServiceImpl.deleteUser(1));
        verify(personDaoRepository).findById((Integer) any());
        verify(personDaoRepository).delete((Person) any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#deleteUser(Integer)}
     */
    @Test
    void testDeleteUser3() throws Exception {
        doNothing().when(personDaoRepository).delete((Person) any());
        when(personDaoRepository.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> personServiceImpl.deleteUser(1));
        verify(personDaoRepository).findById((Integer) any());
    }

    /**
     * Method under test: {@link PersonServiceImpl#findALl()}
     */
    @Test
    void testFindALl() {
        when(personDaoRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(personServiceImpl.findALl().isEmpty());
        verify(personDaoRepository).findAll();
    }

    /**
     * Method under test: {@link PersonServiceImpl#findALl()}
     */
    @Test
    void testFindALl2() {
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId_person(1);
        person.setImage_url("https://example.org/example");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonal_email("jane.doe@example.org");
        person.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person.setUsername("janedoe");

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(person);
        when(personDaoRepository.findAll()).thenReturn(personList);
        assertEquals(1, personServiceImpl.findALl().size());
        verify(personDaoRepository).findAll();
    }

    /**
     * Method under test: {@link PersonServiceImpl#findALl()}
     */
    @Test
    void testFindALl3() {
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId_person(1);
        person.setImage_url("https://example.org/example");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonal_email("jane.doe@example.org");
        person.setSurname("Doe");
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        person.setUsername("janedoe");

        Person person1 = new Person();
        person1.setActive(true);
        person1.setCity("Oxford");
        person1.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setId_person(1);
        person1.setImage_url("https://example.org/example");
        person1.setName("Name");
        person1.setPassword("iloveyou");
        person1.setPersonal_email("jane.doe@example.org");
        person1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setUsername("janedoe");

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person);
        when(personDaoRepository.findAll()).thenReturn(personList);
        assertEquals(2, personServiceImpl.findALl().size());
        verify(personDaoRepository).findAll();
    }

    /**
     * Method under test: {@link PersonServiceImpl#findALl()}
     */
    @Test
    void testFindALl4() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(personDaoRepository.findAll()).thenThrow(new EntityNotFoundException("An error occurred", 1,
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant())));
        assertThrows(EntityNotFoundException.class, () -> personServiceImpl.findALl());
        verify(personDaoRepository).findAll();
    }

    /**
     * Method under test: {@link PersonServiceImpl#findALl()}
     */
    @Test
    void testFindALl5() {
        Person person = mock(Person.class);
        when(person.getActive()).thenReturn(true);
        when(person.getId_person()).thenReturn(1);
        when(person.getCity()).thenReturn("Oxford");
        when(person.getCompany_email()).thenReturn("jane.doe@example.org");
        when(person.getImage_url()).thenReturn("https://example.org/example");
        when(person.getName()).thenReturn("Name");
        when(person.getPassword()).thenReturn("iloveyou");
        when(person.getPersonal_email()).thenReturn("jane.doe@example.org");
        when(person.getSurname()).thenReturn("Doe");
        when(person.getUsername()).thenReturn("janedoe");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(person.getCreated_date()).thenReturn(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        when(person.getTermination_date())
                .thenReturn(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
        doNothing().when(person).setActive((Boolean) any());
        doNothing().when(person).setCity((String) any());
        doNothing().when(person).setCompany_email((String) any());
        doNothing().when(person).setCreated_date((Date) any());
        doNothing().when(person).setId_person((Integer) any());
        doNothing().when(person).setImage_url((String) any());
        doNothing().when(person).setName((String) any());
        doNothing().when(person).setPassword((String) any());
        doNothing().when(person).setPersonal_email((String) any());
        doNothing().when(person).setSurname((String) any());
        doNothing().when(person).setTermination_date((Date) any());
        doNothing().when(person).setUsername((String) any());
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult2 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setCreated_date(Date.from(atStartOfDayResult2.atZone(ZoneId.of("UTC")).toInstant()));
        person.setId_person(1);
        person.setImage_url("https://example.org/example");
        person.setName("Name");
        person.setPassword("iloveyou");
        person.setPersonal_email("jane.doe@example.org");
        person.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        person.setUsername("janedoe");

        ArrayList<Person> personList = new ArrayList<>();
        personList.add(person);
        when(personDaoRepository.findAll()).thenReturn(personList);
        assertEquals(1, personServiceImpl.findALl().size());
        verify(personDaoRepository).findAll();
        verify(person).getActive();
        verify(person).getId_person();
        verify(person).getCity();
        verify(person).getCompany_email();
        verify(person).getImage_url();
        verify(person).getName();
        verify(person).getPassword();
        verify(person).getPersonal_email();
        verify(person).getSurname();
        verify(person).getUsername();
        verify(person).getCreated_date();
        verify(person).getTermination_date();
        verify(person).setActive((Boolean) any());
        verify(person).setCity((String) any());
        verify(person).setCompany_email((String) any());
        verify(person).setCreated_date((Date) any());
        verify(person).setId_person((Integer) any());
        verify(person).setImage_url((String) any());
        verify(person).setName((String) any());
        verify(person).setPassword((String) any());
        verify(person).setPersonal_email((String) any());
        verify(person).setSurname((String) any());
        verify(person).setTermination_date((Date) any());
        verify(person).setUsername((String) any());
    }
}


package com.formacion.BS7_2.person.infraestructure.repository;

import com.formacion.BS7_2.person.domain.model.Person;
import com.formacion.BS7_2.person.infraestructure.dto.input.PersonInputDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = {PersonDaoRepository.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.formacion.BS7_2.person.domain.model"})
@DataJpaTest
class PersonDaoRepositoryTest {

    @Autowired
    private PersonDaoRepository personDaoRepository;

    private Person person;


    @BeforeEach
    void Setup() {




    }

    /**
     * Method under test: {@link PersonDaoRepository#findByUsername(String)}
     */
    @Test
    void testFindByUsername() {

        //give
        PersonInputDto personInputDto = new PersonInputDto();
        personInputDto.setName("carlos");
        personInputDto.setSurname("angulo");
        personInputDto.setPersonal_email("carlos.e.angulo@hotmail.com");
        personInputDto.setCity("madrid");
        personInputDto.setUsername("cah119");
        personInputDto.setPassword("123");
        personInputDto.setCompany_email("test@bosonit.com");
        personInputDto.setImage_url("ididdid");
        personInputDto.setCreated_date(new Date());
        personInputDto.setActive(true);
        personInputDto.setTermination_date(null);
        Person person = new Person(personInputDto);
        //when
        List<Person> personList = personDaoRepository.findByUsername("cah119");

        //then
        assertTrue(personDaoRepository.findByUsername("foo").isEmpty());
    }

    /**
     * Method under test: {@link PersonDaoRepository#findByUsername(String)}
     */
    @Test
    void testFindByUsername2() {
        Person person = new Person();
        person.setActive(true);
        person.setCity("Oxford");
        person.setCompany_email("jane.doe@example.org");
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        person.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
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
        person1.setImage_url("https://example.org/example");
        person1.setName("Name");
        person1.setPassword("iloveyou");
        person1.setPersonal_email("jane.doe@example.org");
        person1.setSurname("Doe");
        LocalDateTime atStartOfDayResult3 = LocalDate.of(1970, 1, 1).atStartOfDay();
        person1.setTermination_date(Date.from(atStartOfDayResult3.atZone(ZoneId.of("UTC")).toInstant()));
        person1.setUsername("janedoe");
        personDaoRepository.save(person);
        personDaoRepository.save(person1);
        assertTrue(personDaoRepository.findByUsername("foo").isEmpty());
    }

    @Tag("savePerson")
    @DisplayName("Save Person")
    @Test
    void SavePersonObject() {
        //give

        PersonInputDto personInputDto = new PersonInputDto();

        personInputDto.setName("carlos");
        personInputDto.setSurname("angulo");
        personInputDto.setPersonal_email("carlos.e.angulo@hotmail.com");
        personInputDto.setCity("madrid");
        personInputDto.setUsername("cah119");
        personInputDto.setPassword("123");
        personInputDto.setCompany_email("test@bosonit.com");
        personInputDto.setImage_url("ididdid");
        personInputDto.setCreated_date(new Date());
        personInputDto.setActive(true);
        personInputDto.setTermination_date(null);
        Person personSave = new Person(personInputDto);

        //when
        personSave = personDaoRepository.save(personSave);

        //then
        assertThat(personSave).isNotNull();
        assertThat(personSave.getId_person()).isGreaterThan(0);
    }

    @Tag("personList")
    @DisplayName("Person List")
    @Test
    void ListPerson() {
        //given
        Person person = new Person();
        person.setName("carlos");
        person.setSurname("angulo");
        person.setPersonal_email("carlos.e.angulo@hotmail.com");
        person.setCity("madrid");
        person.setUsername("cah119");
        person.setPassword("123");
        person.setCompany_email("test@bosonit.com");
        person.setImage_url("ididdid");
        person.setCreated_date(new Date());
        person.setActive(true);
        person.setTermination_date(null);


        Person person2 = new Person();
        person2.setName("mariacdcd");
        person2.setSurname("perez");
        person2.setPersonal_email("mpe@hotmail.com");
        person2.setCity("madrid");
        person2.setUsername("mp1235");
        person2.setPassword("123");
        person2.setCompany_email("mp@bosonit.com");
        person2.setImage_url("ididdid");
        person2.setCreated_date(new Date());
        person2.setActive(true);
        person2.setTermination_date(null);

        personDaoRepository.save(person);
        personDaoRepository.save(person2);


        //when
        List<Person> personList = personDaoRepository.findAll();


        //then
        assertThat(personList).isNotNull();
        assertThat(personList.size()).isEqualTo(2);

    }
       @Tag("getpersonById")
        @DisplayName("GetPersonById")
       @Test
        void getPersonById(){
              //give
            Person person = new Person();
            person.setActive(true);
            person.setCity("Oxford");
            person.setCompany_email("jane.doe@example.org");
            LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
            person.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
            person.setImage_url("https://example.org/example");
            person.setName("Name");
            person.setPassword("iloveyou");
            person.setPersonal_email("jane.doe@example.org");
            person.setSurname("Doe");
            LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
            person.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
            person.setUsername("janedoe");
            personDaoRepository.save(person);
            //when
           Person personBd = personDaoRepository.findById(person.getId_person()).get();
           //then
            assertThat(personBd).isNotNull();
        }

        @Tag("updatePerson")
        @DisplayName("updatePerson")
        @Test
        void updatePersonTest(){
            //give

            Person person = new Person();
            person.setActive(true);
            person.setCity("Oxford");
            person.setCompany_email("jane.doe@example.org");
            LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
            person.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
            person.setImage_url("https://example.org/example");
            person.setName("Name");
            person.setPassword("iloveyou");
            person.setPersonal_email("jane.doe@example.org");
            person.setSurname("Doe");
            LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
            person.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
            person.setUsername("janedoe");
            personDaoRepository.save(person);
            //when

            Person personNow = personDaoRepository.findById(person.getId_person()).get();
            personNow.setCompany_email("ca@bosonit.com");
            personNow.setName("jose");
            personNow.setSurname("guzman");
            Person personUpdate = personDaoRepository.save(personNow);
            //then
            assertThat(personUpdate.getCompany_email()).isEqualTo("ca@bosonit.com");
            assertThat(personUpdate.getName()).isEqualTo("jose");
        }

        @Tag("deleteperson")
        @DisplayName("deletePerson")
        @Test
        void testDeletePerson(){
            //give
            Person person = new Person();
            person.setActive(true);
            person.setCity("Oxford");
            person.setCompany_email("jane.doe@example.org");
            LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
            person.setCreated_date(Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
            person.setImage_url("https://example.org/example");
            person.setName("Name");
            person.setPassword("iloveyou");
            person.setPersonal_email("jane.doe@example.org");
            person.setSurname("Doe");
            LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
            person.setTermination_date(Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant()));
            person.setUsername("janedoe");
            personDaoRepository.save(person);

            //when
            personDaoRepository.deleteById(person.getId_person());
            Optional<Person> personOptional = personDaoRepository.findById(person.getId_person());
            //then
            assertThat(personOptional).isEmpty();
        }


}
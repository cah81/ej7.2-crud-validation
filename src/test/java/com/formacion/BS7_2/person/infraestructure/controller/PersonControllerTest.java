package com.formacion.BS7_2.person.infraestructure.controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.formacion.BS7_2.person.application.services.PersonService;
import com.formacion.BS7_2.person.domain.model.Person;
import com.formacion.BS7_2.person.infraestructure.dto.input.PersonInputDto;
import com.formacion.BS7_2.person.infraestructure.dto.output.PersonOutputDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {PersonController.class})
@ExtendWith(SpringExtension.class)
class PersonControllerTest {
    @Autowired
    private PersonController personController;

    @MockBean
    private PersonService personService;

    /**
     * Method under test: {@link PersonController#addPerson(PersonInputDto)}
     */
    @Test
    void testAddPerson() throws Exception {
        when(personService.addUser((PersonInputDto) any())).thenReturn(new PersonOutputDto(new Person()));

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
        String content = (new ObjectMapper()).writeValueAsString(personInputDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/person/addPerson")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(personController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id_person\":null,\"username\":null,\"password\":null,\"name\":null,\"surname\":null,\"company_email\":null,"
                                        + "\"personal_email\":null,\"city\":null,\"active\":null,\"created_date\":null,\"image_url\":null,\"termination"
                                        + "_date\":null}"));
    }
}


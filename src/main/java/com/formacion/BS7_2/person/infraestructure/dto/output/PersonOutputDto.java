package com.formacion.BS7_2.person.infraestructure.dto.output;

import com.formacion.BS7_2.person.domain.model.Person;
import lombok.Data;
import java.util.Date;

/**
 * A DTO for the {@link com.formacion.BS7_2.person.domain.model.Person} entity
 */
public class PersonOutputDto {
    private Integer id_person;
    private String username;
    private String password;
    private String name;

    private String surname;
    private String company_email;
    private String personal_email;
    private String city;
    private Boolean active;

    public Integer getId_person() {
        return id_person;
    }

    public void setId_person(Integer id_person) {
        this.id_person = id_person;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompany_email() {
        return company_email;
    }

    public void setCompany_email(String company_email) {
        this.company_email = company_email;
    }

    public String getPersonal_email() {
        return personal_email;
    }

    public void setPersonal_email(String personal_email) {
        this.personal_email = personal_email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Date getTermination_date() {
        return termination_date;
    }

    public void setTermination_date(Date termination_date) {
        this.termination_date = termination_date;
    }

    private  Date created_date;
    private  String image_url;
    private  Date termination_date;


    public PersonOutputDto(Person person) {
        this.id_person = person.getId_person();
        this.username = person.getUsername();
        this.password =person.getPassword();
        this.name = person.getName();
        this.surname = person.getSurname();
        this.company_email = person.getCompany_email();
        this.personal_email = person.getPersonal_email();
        this.city = person.getCity();
        this.active = person.getActive();
        this.created_date = person.getCreated_date();
        this.image_url= person.getImage_url();
        this.termination_date = person.getTermination_date();
    }


}



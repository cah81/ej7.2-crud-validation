package com.formacion.BS7_2.person.domain.model;


import com.formacion.BS7_2.person.infraestructure.dto.input.PersonInputDto;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Date;


@Data

@Entity
@Table(name = "persons")

public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_person")
    private Integer id_person;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String company_email;
    @Column
    private String personal_email;
    @Column
    private String city;
    @Column
    private Boolean active;

    @Column(name ="create_at")
    @Temporal(TemporalType.DATE)
    private Date created_date;
    private String image_url;
    private Date termination_date;

    public Person(String username, String password, String name, String surname, String company_email, String personal_email, String city, Boolean active, Date created_date, String image_url, Date termination_date) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.company_email = company_email;
        this.personal_email = personal_email;
        this.city = city;
        this.active = active;
        this.created_date = created_date;
        this.image_url = image_url;
        this.termination_date = termination_date;
    }

    public Person() {
    }

    public Person(PersonInputDto personInputDto){
       this.username = personInputDto.getUsername();
       this.password = personInputDto.getPassword();
       this.name =personInputDto.getName();
       this.surname = personInputDto.getSurname();
       this.company_email= personInputDto.getCompany_email();
       this.personal_email= personInputDto.getPersonal_email();
       this.city = personInputDto.getCity();
       this.active = personInputDto.getActive();
       this.created_date = personInputDto.getCreated_date();
       this.image_url = personInputDto.getImage_url();
       this.termination_date= personInputDto.getTermination_date();
   }







    private static final long serialVersionUID = 1L;


}

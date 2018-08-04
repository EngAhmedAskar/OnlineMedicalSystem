package com.OMS.ClinicProject.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "MedicalProfessional")
public class MedicalProfessional {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "name")
    @NotEmpty(message = "*Please provide name")
    private String name;


    @Column(name = "type")
    @NotEmpty(message = "*Please provide type")
    private String type;

    @Column(name = "mobile")
    @NotEmpty(message = "*Please provide mobile")
    private String mobile;

    @Column(name = "phone")
    @NotEmpty(message = "*Please provide phone")
    private String phone;

    @Column(name = "credential")
    @NotEmpty(message = "*Please provide credential")
    private String credential;

    @Column(name = "username")
    @NotEmpty(message = "*Please provide User Name")
    private String userName;

    @Column(name = "password")
    @NotEmpty(message = "*Please provide PassWord")
    private String passWord;

    @ManyToMany
    private List<Speciality> rofessionalSpecialityList;
}

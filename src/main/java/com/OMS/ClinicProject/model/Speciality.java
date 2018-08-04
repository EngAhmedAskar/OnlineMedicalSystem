package com.OMS.ClinicProject.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "*Please provide name")
    private String name;

    @Column(name = "description")
    @NotEmpty(message = "*Please provide description")
    private String description;



    @ManyToMany(mappedBy = "SpecialityList")
    private List<Clinic> ClinicList;
    @ManyToMany(mappedBy = "rofessionalSpecialityList")
    private List<MedicalProfessional> medicalProfessionals;
}

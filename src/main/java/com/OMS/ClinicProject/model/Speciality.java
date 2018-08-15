package com.OMS.ClinicProject.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Speciality")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Clinic> getClinicList() {
        return ClinicList;
    }

    public void setClinicList(List<Clinic> clinicList) {
        ClinicList = clinicList;
    }

    public List<MedicalProfessional> getMedicalProfessionals() {
        return medicalProfessionals;
    }

    public void setMedicalProfessionals(List<MedicalProfessional> medicalProfessionals) {
        this.medicalProfessionals = medicalProfessionals;
    }

    public Speciality() {
    }



    @ManyToMany(mappedBy = "SpecialityList")
    private List<Clinic> ClinicList;

    @ManyToMany(mappedBy = "professionalSpecialityList")
    private List<MedicalProfessional> medicalProfessionals;
}

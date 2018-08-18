package com.OMS.ClinicProject.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "MedicalHistoryItem")
public class MedicalHistoryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description")
    @NotEmpty(message = "*Please provide description")
    private String description;

    @Column(name = "diagnosis")
    @NotEmpty(message = "*Please provide diagnosis")
    private String diagnosis;

    @Column(name = "medicine")
    @NotEmpty(message = "*Please provide medicine")
    private String medicine;


    @ManyToOne
    private Patient myPatient;

    public MedicalHistoryItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public Patient getMyPatient() {
        return myPatient;
    }

    public void setMyPatient(Patient myPatient) {
        this.myPatient = myPatient;
    }
}

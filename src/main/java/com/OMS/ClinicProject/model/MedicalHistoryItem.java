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
}

package com.OMS.ClinicProject.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name="Allergy")
public class Allergy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "description")
    @NotEmpty(message = "*Please provide description")
    private String description;

}

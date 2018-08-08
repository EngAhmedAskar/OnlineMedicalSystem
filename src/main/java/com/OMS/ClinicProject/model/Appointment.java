package com.OMS.ClinicProject.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    @NotEmpty(message = "*Please provide date")
    private LocalDate date;

    @Column(name = "time")
    @NotEmpty(message = "*Please provide time")
    private LocalTime time;

    @Column(name = "diagnosis")
    @NotEmpty(message = "*Please provide diagnosis")
    private String diagnosis;

    @Column(name = "medicine")
    @NotEmpty(message = "*Please provide medicine")
    private String medicine;


    @Column(name = "status")
    @NotEmpty(message = "*Please provide status")
    private int status;

    @Column(name = "description")
    @NotEmpty(message = "*Please provide description")
    private String description;

    @ManyToOne
    private Clinic myClinic;


    @OneToOne
    @JoinColumn(name="timeSlot_id")
    private TimeSlot timeSlot;



}

package com.OMS.ClinicProject.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="Clinic")
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "address")
    @NotEmpty(message = "*Please provide address")
    private String address;


    @Column(name = "city")
    @NotEmpty(message = "*Please provide city")
    private String city;

    @Column(name = "country")
    @NotEmpty(message = "*Please provide country")
    private String country;


    @Column(name = "zipcode")
    @NotEmpty(message = "*Please provide zipcode")
    private String zipcode;


    @ManyToMany
    private List<Speciality> SpecialityList;

    @OneToMany(mappedBy = "myClinic")
    List<Appointment> AppointmentList ;
}

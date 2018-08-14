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

    @Column(name = "name")
    @NotEmpty(message = "*Please provide name")
    private String name;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Speciality> getSpecialityList() {
        return SpecialityList;
    }

    public void setSpecialityList(List<Speciality> specialityList) {
        SpecialityList = specialityList;
    }

    public List<Appointment> getAppointmentList() {
        return AppointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        AppointmentList = appointmentList;
    }

    public Clinic() {
    }

    public Clinic(@NotEmpty(message = "*Please provide address") String address, @NotEmpty(message = "*Please provide name") String name, @NotEmpty(message = "*Please provide city") String city, @NotEmpty(message = "*Please provide country") String country, @NotEmpty(message = "*Please provide zipcode") String zipcode, List<Speciality> specialityList, List<Appointment> appointmentList) {
        this.address = address;
        this.name = name;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
        SpecialityList = specialityList;
        AppointmentList = appointmentList;
    }
}

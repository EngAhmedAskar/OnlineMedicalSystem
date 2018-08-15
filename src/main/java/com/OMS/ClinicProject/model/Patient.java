package com.OMS.ClinicProject.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "*Please provide name")
    private String name;

    @Column(name = "address")
    @NotEmpty(message = "*Please provide address")
    private String address;

    @Column(name = "mobile")
    @NotEmpty(message = "*Please provide mobile")
    private String mobile;

    @Column(name = "phone")
    @NotEmpty(message = "*Please provide phone")
    private String phone;

    @Column(name = "username")
    @NotEmpty(message = "*Please provide username")
    private String username;

    @Column(name = "password")
    @NotEmpty(message = "*Please provide password")
    private String password;

    @Column(name = "email")
    @NotEmpty(message = "*Please provide email")
    private String email;

    @OneToMany(mappedBy = "patient")
    List<Appointment> AppointmentList ;

    //    @JoinTable(name = "MedicalHistoryItem")
    @OneToMany(mappedBy = "myPatient")
    List<MedicalHistoryItem> medicalHistoryItems;

//    @OneToMany(mappedBy = "myPatientAllergy")
//    List<Allergy> allergyList;
    @ManyToMany(mappedBy = "myPatientAllergy")
    private List<Allergy> allergyList;

    public Patient() {
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Appointment> getAppointmentList() {
        return AppointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        AppointmentList = appointmentList;
    }

    public List<MedicalHistoryItem> getMedicalHistoryItems() {
        return medicalHistoryItems;
    }

    public void setMedicalHistoryItems(List<MedicalHistoryItem> medicalHistoryItems) {
        this.medicalHistoryItems = medicalHistoryItems;
    }

    public List<Allergy> getAllergyList() {
        return allergyList;
    }

    public void setAllergyList(List<Allergy> allergyList) {
        this.allergyList = allergyList;
    }
}

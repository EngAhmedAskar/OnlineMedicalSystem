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
    private LocalDate appintmentdate;

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

    @ManyToOne
    private Patient patient;


    @ManyToOne
    private MedicalProfessional medicalProfessional;


    @OneToOne
    @JoinColumn(name="timeSlot_id")
    private TimeSlot timeSlot;

    public Appointment(@NotEmpty(message = "*Please provide date") LocalDate appintmentdate, @NotEmpty(message = "*Please provide time") LocalTime time, @NotEmpty(message = "*Please provide diagnosis") String diagnosis, @NotEmpty(message = "*Please provide medicine") String medicine, @NotEmpty(message = "*Please provide status") int status, @NotEmpty(message = "*Please provide description") String description, Clinic myClinic, Patient patient, MedicalProfessional medicalProfessional, TimeSlot timeSlot) {
        this.appintmentdate = appintmentdate;
        this.time = time;
        this.diagnosis = diagnosis;
        this.medicine = medicine;
        this.status = status;
        this.description = description;
        this.myClinic = myClinic;
        this.patient = patient;
        this.medicalProfessional = medicalProfessional;
        this.timeSlot = timeSlot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getAppintmentdate() {
        return appintmentdate;
    }

    public void setAppintmentdate(LocalDate appintmentdate) {
        this.appintmentdate = appintmentdate;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Clinic getMyClinic() {
        return myClinic;
    }

    public void setMyClinic(Clinic myClinic) {
        this.myClinic = myClinic;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public MedicalProfessional getMedicalProfessional() {
        return medicalProfessional;
    }

    public void setMedicalProfessional(MedicalProfessional medicalProfessional) {
        this.medicalProfessional = medicalProfessional;
    }

    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }
}

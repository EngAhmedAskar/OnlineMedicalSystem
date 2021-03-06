package com.OMS.ClinicProject.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "TimeSlot")
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fromTime")
    @NotEmpty(message = "*Please provide from")
    private String from;

    @Column(name = "toTime")
    @NotEmpty(message = "*Please provide to")
    private String to;

    public TimeSlot() {
    }


    public TimeSlot(@NotEmpty(message = "*Please provide from") String from, @NotEmpty(message = "*Please provide to") String to, Appointment appointment) {
        this.from = from;
        this.to = to;
        this.appointment = appointment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    @OneToOne(mappedBy =  "timeSlot")
    private Appointment appointment;
}

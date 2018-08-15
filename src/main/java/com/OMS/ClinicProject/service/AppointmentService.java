package com.OMS.ClinicProject.service;

import com.OMS.ClinicProject.model.Appointment;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AppointmentService {
    List<Appointment> findAll();
    Appointment save(Appointment appointment);
    Appointment findOne(Long id);
    void delete(Long id);
    List<Appointment> findAllappointment(Long id, int status, LocalDate appointmentDate);
}

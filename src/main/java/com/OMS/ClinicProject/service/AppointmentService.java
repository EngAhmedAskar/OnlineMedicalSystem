package com.OMS.ClinicProject.service;

import com.OMS.ClinicProject.model.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> findAll();
    Appointment save(Appointment appointment);
    Appointment findOne(Long id);
    void delete(Long id);
}

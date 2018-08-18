package com.OMS.ClinicProject.service.impl;


import com.OMS.ClinicProject.model.Appointment;
import com.OMS.ClinicProject.repository.AppointmentRepository;
import com.OMS.ClinicProject.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service("AppointmentService")
public class AppointmentServiceImpl implements AppointmentService {


    @Autowired
    AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }


    @Override
    public Appointment save(Appointment Appointment) {
        return appointmentRepository.save(Appointment);
    }

    @Override
    public Appointment findOne(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public List<Appointment> findAllappointment(Long id, int status, LocalDate appointmentDate) {
        return appointmentRepository.findByDate(id, status, appointmentDate);
    }
}

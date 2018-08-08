package com.OMS.ClinicProject.service;

import com.OMS.ClinicProject.model.Clinic;

import java.util.List;

public interface ClinicService {
    List<Clinic> findAll();
    Clinic save(Clinic clinic);
    Clinic findOne(Long id);
    void delete(Long id);
}

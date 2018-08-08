package com.OMS.ClinicProject.service;

import com.OMS.ClinicProject.model.Speciality;
import java.util.List;

public interface SpecialityService {
    List<Speciality> findAll();
    Speciality save(Speciality speciality);
    Speciality findOne(Long id);
    void delete(Long id);
}

package com.OMS.ClinicProject.service;
import com.OMS.ClinicProject.model.MedicalProfessional;
import java.util.List;
public interface MedicalProfessionalService {
    List<MedicalProfessional> findAll();
    MedicalProfessional save(MedicalProfessional medicalProfessional);
    MedicalProfessional findOne(Long id);
    void delete(Long id);
}

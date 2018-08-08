package com.OMS.ClinicProject.service.impl;
import com.OMS.ClinicProject.model.MedicalProfessional;
import com.OMS.ClinicProject.repository.MedicalProfessionalRepository;
import com.OMS.ClinicProject.service.MedicalProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("MedicalProfessionalService")
public class MedicalProfessionalServiceImpl implements MedicalProfessionalService {
    @Autowired
    MedicalProfessionalRepository MedicalProfessionalRepository;

    @Override
    public List<MedicalProfessional> findAll() {
        return MedicalProfessionalRepository.findAll();
    }

    @Override
    public MedicalProfessional save(MedicalProfessional medicalProfessional) {
        return MedicalProfessionalRepository.save(medicalProfessional);
    }

    @Override
    public MedicalProfessional findOne(Long id) {
        return MedicalProfessionalRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        MedicalProfessionalRepository.deleteById(id);
    }
}

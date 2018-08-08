package com.OMS.ClinicProject.service.impl;

import com.OMS.ClinicProject.model.Speciality;
import com.OMS.ClinicProject.repository.SpecialityRepository;
import com.OMS.ClinicProject.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

@Service("SpecialityService")
public class SpecialityServiceImpl implements SpecialityService {


    @Autowired
    SpecialityRepository SpecialityRepository;

    @Override
    public List<Speciality> findAll() {
        return SpecialityRepository.findAll();
    }

    @Override
    public Speciality save(Speciality speciality) {
        return SpecialityRepository.save(speciality);
    }

    @Override
    public Speciality findOne(Long id) {
        return SpecialityRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        SpecialityRepository.deleteById(id);
    }
}

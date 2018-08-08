package com.OMS.ClinicProject.service.impl;

import com.OMS.ClinicProject.model.Clinic;
import com.OMS.ClinicProject.repository.ClinicRepository;
import com.OMS.ClinicProject.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("ClinicService")
public class ClinicServiceImpl implements ClinicService {


    @Autowired
    com.OMS.ClinicProject.repository.ClinicRepository ClinicRepository;

    @Override
    public List<Clinic> findAll() {
        return ClinicRepository.findAll();
    }

    @Override
    public Clinic save(Clinic Clinic) {
        return ClinicRepository.save(Clinic);
    }

    @Override
    public Clinic findOne(Long id) {
        return ClinicRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        ClinicRepository.deleteById(id);
    }
}

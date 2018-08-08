package com.OMS.ClinicProject.service.impl;
import com.OMS.ClinicProject.model.Allergy;
import com.OMS.ClinicProject.repository.AllergyRepository;
import com.OMS.ClinicProject.service.AllergyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

@Service("AllergyService")
public class AllergyServiceImpl implements AllergyService {
    @Autowired
    AllergyRepository AllergyRepository;

    @Override
    public List<Allergy> findAll() {
        return AllergyRepository.findAll();
    }

    @Override
    public Allergy save(Allergy allergy) {
        return AllergyRepository.save(allergy);
    }

    @Override
    public Allergy findOne(Long id) {
        return AllergyRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        AllergyRepository.deleteById(id);
    }
}

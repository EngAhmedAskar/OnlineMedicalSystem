package com.OMS.ClinicProject.service;
import com.OMS.ClinicProject.model.Allergy;
import java.util.List;
public interface AllergyService {
    List<Allergy> findAll();
    Allergy save(Allergy allergy);
    Allergy findOne(Long id);
    void delete(Long id);
}

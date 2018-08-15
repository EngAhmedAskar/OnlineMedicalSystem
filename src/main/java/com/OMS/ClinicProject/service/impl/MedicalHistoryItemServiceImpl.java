package com.OMS.ClinicProject.service.impl;

import com.OMS.ClinicProject.model.MedicalHistoryItem;
import com.OMS.ClinicProject.repository.MedicalHistoryItemRepository;
import com.OMS.ClinicProject.service.MedicalHistoryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service("MedicalHistoryItemService")
public class MedicalHistoryItemServiceImpl implements MedicalHistoryItemService {


    @Autowired
    MedicalHistoryItemRepository medicalHistoryItemRepository;

    @Override
    public List<MedicalHistoryItem> findAll() {
        return medicalHistoryItemRepository.findAll();
    }


    @Override
    public MedicalHistoryItem save(MedicalHistoryItem MedicalHistoryItem) {
        return medicalHistoryItemRepository.save(MedicalHistoryItem);
    }

    @Override
    public MedicalHistoryItem findOne(Long id) {
        return medicalHistoryItemRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        medicalHistoryItemRepository.deleteById(id);
    }

    @Override
    public List<MedicalHistoryItem> findByPatientID(Long id) {
      return   medicalHistoryItemRepository.findByPatientID(id);
    }


}

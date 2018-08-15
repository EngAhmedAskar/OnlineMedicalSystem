package com.OMS.ClinicProject.service;


import com.OMS.ClinicProject.model.MedicalHistoryItem;
import java.util.List;

public interface MedicalHistoryItemService {
    List<MedicalHistoryItem> findAll();
    MedicalHistoryItem save(MedicalHistoryItem clinic);
    MedicalHistoryItem findOne(Long id);
    void delete(Long id);
    List<MedicalHistoryItem> findByPatientID(Long id);
}

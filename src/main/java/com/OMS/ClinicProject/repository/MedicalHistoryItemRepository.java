package com.OMS.ClinicProject.repository;

import com.OMS.ClinicProject.model.Appointment;
import com.OMS.ClinicProject.model.MedicalHistoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface MedicalHistoryItemRepository extends JpaRepository<MedicalHistoryItem, Long> {


    @Query(value = "SELECT a FROM MedicalHistoryItem a where a.myPatient.id=?1")
    List<MedicalHistoryItem> findByPatientID(Long mpId);
}

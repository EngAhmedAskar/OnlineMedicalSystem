package com.OMS.ClinicProject.repository;

import com.OMS.ClinicProject.model.MedicalHistoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalHistoryItemRepository extends JpaRepository<MedicalHistoryItem, Long> {
}

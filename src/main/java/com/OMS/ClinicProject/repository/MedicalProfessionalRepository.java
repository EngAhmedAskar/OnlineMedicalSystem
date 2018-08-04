package com.OMS.ClinicProject.repository;

import com.OMS.ClinicProject.model.MedicalProfessional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalProfessionalRepository extends JpaRepository<MedicalProfessional, Long> {
}

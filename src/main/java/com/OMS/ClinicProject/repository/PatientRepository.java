package com.OMS.ClinicProject.repository;

import com.OMS.ClinicProject.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}


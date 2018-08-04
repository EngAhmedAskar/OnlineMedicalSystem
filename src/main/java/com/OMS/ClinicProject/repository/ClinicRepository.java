package com.OMS.ClinicProject.repository;

import com.OMS.ClinicProject.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
}

package com.OMS.ClinicProject.repository;

import com.OMS.ClinicProject.model.Allergy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergyRepository  extends JpaRepository<Allergy, Long> {
}

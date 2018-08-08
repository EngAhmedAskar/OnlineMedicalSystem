package com.OMS.ClinicProject.repository;

import com.OMS.ClinicProject.model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
}

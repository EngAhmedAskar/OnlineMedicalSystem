package com.OMS.ClinicProject.repository;

import com.OMS.ClinicProject.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository  extends JpaRepository<Appointment, Long> {
}

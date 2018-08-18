package com.OMS.ClinicProject.repository;

import com.OMS.ClinicProject.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface AppointmentRepository  extends JpaRepository<Appointment, Long> {

    @Query(value = "SELECT a FROM Appointment a where a.medicalProfessional.id=?1 and a.status = ?2 and a.appintmentdate=?3")
    List<Appointment> findByDate(Long mpId, int status, LocalDate appointmentdate);
}

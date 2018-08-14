package com.OMS.ClinicProject.repository;

import com.OMS.ClinicProject.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface AppointmentRepository  extends JpaRepository<Appointment, Long> {

//    @Query("SELECT t FROM Thing t WHERE t.fooIn = ?1 AND t.bar = ?2")
//    List<Appointment> findByFooInAndBar(String fooIn, Date dateFilter);
}

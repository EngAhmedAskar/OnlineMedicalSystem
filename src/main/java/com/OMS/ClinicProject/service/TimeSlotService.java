package com.OMS.ClinicProject.service;

import com.OMS.ClinicProject.model.TimeSlot;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TimeSlotService {
    List<TimeSlot> findAll();



}

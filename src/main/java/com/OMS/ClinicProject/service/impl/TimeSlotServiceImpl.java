package com.OMS.ClinicProject.service.impl;

import com.OMS.ClinicProject.model.TimeSlot;
import com.OMS.ClinicProject.repository.TimeSlotRepository;
import com.OMS.ClinicProject.service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("TimeSlotService")
public class TimeSlotServiceImpl implements TimeSlotService {


    @Autowired
    TimeSlotRepository timeSlotRepository;

    @Override
    public List<TimeSlot> findAll() {
        return timeSlotRepository.findAll();
    }
}

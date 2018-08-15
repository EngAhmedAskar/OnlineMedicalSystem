package com.OMS.ClinicProject.controller;

import com.OMS.ClinicProject.model.*;
import com.OMS.ClinicProject.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;


@Controller
public class AppointmentController {


    @Autowired
    AppointmentService appointmentService;
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private ClinicService clinicService;
    @Autowired
    private TimeSlotService timeSlotService;


    @Autowired
    private MedicalProfessionalService medicalProfessionalService;

    @RequestMapping(value = "/appointments", method = RequestMethod.GET)
    public ModelAndView allergies() {
        List<Appointment> allergies = appointmentService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allergies", allergies);
        modelAndView.setViewName("Appointment/AppointmentList");
        return modelAndView;
    }


    @RequestMapping(value = "/AddAppointment", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("Appointment", new Appointment());
        List<Speciality> Specialities = specialityService.findAll();
        model.addAttribute("SpecialityList", Specialities);
        List<TimeSlot> timeSlots = timeSlotService.findAll();
        model.addAttribute("timeSlots", timeSlots);

        List<Clinic> ClinicList = clinicService.findAll();
        model.addAttribute("ClinicList", ClinicList);

        List<MedicalProfessional> medicalProfessionals = medicalProfessionalService.findAll();
        model.addAttribute("medicalProfessionals", medicalProfessionals);
        return "Appointment/AddAppointment";
    }


    @RequestMapping(value = "/AddAppointment", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("Appointment") Appointment appointment,
                       BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            List<Speciality> Specialities = specialityService.findAll();
            model.addAttribute("SpecialityList", Specialities);
            return "Appointment/AddAppointment";
        }
        appointment.setStatus((int) Status.Reserved.getValue());
        Patient p = new Patient();

        p.setId(Long.valueOf(1));
        appointment.setPatient(p);
        appointment = appointmentService.save(appointment);
        return "redirect:/Clinics";
    }
}

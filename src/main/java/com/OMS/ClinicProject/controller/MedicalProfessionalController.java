package com.OMS.ClinicProject.controller;

import com.OMS.ClinicProject.model.*;
import com.OMS.ClinicProject.service.AppointmentService;
import com.OMS.ClinicProject.service.MedicalHistoryItemService;
import com.OMS.ClinicProject.service.MedicalProfessionalService;
import com.OMS.ClinicProject.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class MedicalProfessionalController {
    @Autowired
    private MedicalProfessionalService medicalProfessionalService;
    @Autowired
    private SpecialityService specialityService;
    @Autowired
    private MedicalHistoryItemService medicalHistoryItemService;
    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(value = "/medicalProfessionals", method = RequestMethod.GET)
    public ModelAndView medicalProfessionals() {
        List<MedicalProfessional> medicalProfessionals = medicalProfessionalService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("medicalProfessionals", medicalProfessionals);
        modelAndView.setViewName("medicalProfessional/medicalProfessionalList");
        return modelAndView;
    }

    @RequestMapping(value = "/medicalProfessional", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("medicalProfessional", new MedicalProfessional());
        List<Speciality> Specialities = specialityService.findAll();
        model.addAttribute("professionalSpecialityList", Specialities);
        return "medicalProfessional/edit";
    }

    @RequestMapping(value = "/medicalProfessional", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("medicalProfessional") MedicalProfessional medicalProfessional,
                       BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            List<Speciality> Specialities = specialityService.findAll();
            model.addAttribute("professionalSpecialityList", Specialities);
            return "medicalProfessional/edit";
        }
        medicalProfessional = medicalProfessionalService.save(medicalProfessional);
        return "redirect:/medicalProfessionals";
    }

    @RequestMapping(value = "/medicalProfessional/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("medicalProfessional", medicalProfessionalService.findOne(id));
        List<Speciality> Specialities = specialityService.findAll();
        model.addAttribute("professionalSpecialityList", Specialities);
        return "medicalProfessional/edit";
    }

    @RequestMapping(value = "/medicalProfessional/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id, Model model) {
        medicalProfessionalService.delete(id);
        return "redirect:/medicalProfessionals";
    }


    @RequestMapping(value = "/medicalProfessionalAppointment", method = RequestMethod.GET)
    public ModelAndView medicalProfessionalAppointment() {
        DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        LocalDate date = LocalDate.now();
        List<Appointment> Appointments = appointmentService.findAllappointment(Long.valueOf(1), 0, date);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Appointments", Appointments);
        modelAndView.setViewName("medicalProfessional/MedicalProfessionalAppointment");
        return modelAndView;
    }


    @RequestMapping(value = "/AppointmentDetails/{id}", method = RequestMethod.GET)
    public String AppointmentDetail(@PathVariable Long id, Model model) {
        Appointment appointment = appointmentService.findOne(id);
        model.addAttribute("appointment", appointment);
        String msg = "";
        List<MedicalHistoryItem> medicalHistoryItems = medicalHistoryItemService.findByPatientID(appointment.getPatient().getId());
        model.addAttribute("medicalHistoryItems", medicalHistoryItems);
        if (medicalHistoryItems.size() == 0) {
            msg = "No Medical History For this patient";

        }
        model.addAttribute("msg", msg);
        return "Appointment/AppointmentDetails";
    }

    @RequestMapping(value = "/AppointmentDetails", method = RequestMethod.POST)
    public String UpdateAppointmentDetail(@Valid @ModelAttribute("appointment") Appointment appointment,
                                          BindingResult result, Model model) {

//        if (result.hasErrors()) {
//            return "/AppointmentDetails/{id}";
//        }
        MedicalHistoryItem mHI = new MedicalHistoryItem();
        Appointment newappointment = new Appointment();
        Long id = appointment.getId();
        newappointment = appointmentService.findOne(id);
        newappointment.setDescription(appointment.getDescription());
        newappointment.setDiagnosis(appointment.getDiagnosis());
        newappointment.setMedicine(appointment.getMedicine());
        mHI.setMyPatient(newappointment.getPatient());
        mHI.setDescription(newappointment.getDescription());
        mHI.setDiagnosis(newappointment.getDiagnosis());
        mHI.setMedicine(newappointment.getMedicine());
        mHI = medicalHistoryItemService.save(mHI);
        newappointment.setStatus(Status.completed.getValue());
        newappointment = appointmentService.save(newappointment);
        return "redirect:/medicalProfessionalAppointment";
    }
}

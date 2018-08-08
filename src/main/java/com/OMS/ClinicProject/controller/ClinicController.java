package com.OMS.ClinicProject.controller;

import com.OMS.ClinicProject.model.Clinic;

import com.OMS.ClinicProject.model.Speciality;
import com.OMS.ClinicProject.service.ClinicService;
import com.OMS.ClinicProject.service.SpecialityService;
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
public class ClinicController {

    @Autowired
    private ClinicService clinicService;
    @Autowired
    private SpecialityService specialityService;
    @RequestMapping(value="/Clinics", method = RequestMethod.GET)
    public ModelAndView Clinic(){
        List<Clinic> Clinics = clinicService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Clinics", Clinics);
        modelAndView.setViewName("Clinic/ClinicsList");
        return modelAndView;
    }


    @RequestMapping(value="/AddClinic", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("Clinic", new Clinic());
        List<Speciality> Specialities = specialityService.findAll();
        model.addAttribute("SpecialityList", Specialities);
        return "Clinic/AddClinic";
    }


    @RequestMapping(value = "/AddClinic", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("Clinic") Clinic clinic,
                       BindingResult result, Model model)  {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            List<Speciality> Specialities = specialityService.findAll();
            model.addAttribute("SpecialityList", Specialities);
            return "Clinic/AddClinic";
        }
        clinic = clinicService.save(clinic);
        return "redirect:/Clinics";
    }
}


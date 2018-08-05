package com.OMS.ClinicProject.controller;

import com.OMS.ClinicProject.model.Speciality;
import com.OMS.ClinicProject.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @RequestMapping(value="/speciality", method = RequestMethod.GET)
    public ModelAndView speciality(){
        List<Speciality> Specialities = specialityService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("Specialities", Specialities);
        modelAndView.setViewName("speciality/specialityList");
        return modelAndView;
    }
}

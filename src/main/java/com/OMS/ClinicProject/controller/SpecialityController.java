package com.OMS.ClinicProject.controller;

import com.OMS.ClinicProject.model.Speciality;
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

    @RequestMapping(value="/Addspeciality", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("Speciality", new Speciality());
        return "speciality/AddSpeciality";
    }


    @RequestMapping(value = "/Addspeciality", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("Speciality") Speciality speciality,
                       BindingResult result, Model model)  {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "speciality/AddSpeciality";
        }
        speciality = specialityService.save(speciality);
        return "redirect:/speciality";
    }
}

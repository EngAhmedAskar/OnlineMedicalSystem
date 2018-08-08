package com.OMS.ClinicProject.controller;
import com.OMS.ClinicProject.model.MedicalProfessional;
import com.OMS.ClinicProject.model.Speciality;
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
import java.util.List;

@Controller
public class MedicalProfessionalController {
    @Autowired
    private MedicalProfessionalService medicalProfessionalService;
    @Autowired
    private SpecialityService specialityService;
    @RequestMapping(value="/medicalProfessionals", method = RequestMethod.GET)
    public ModelAndView medicalProfessionals() {
        List<MedicalProfessional> medicalProfessionals = medicalProfessionalService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("medicalProfessionals", medicalProfessionals);
        modelAndView.setViewName("medicalProfessional/medicalProfessionalList");
        return modelAndView;
    }
    @RequestMapping(value="/medicalProfessional", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("medicalProfessional", new MedicalProfessional());
        List<Speciality> Specialities = specialityService.findAll();
        model.addAttribute("professionalSpecialityList", Specialities);
        return "medicalProfessional/edit";
    }

    @RequestMapping(value = "/medicalProfessional", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("medicalProfessional") MedicalProfessional medicalProfessional,
                       BindingResult result, Model model)  {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            List<Speciality> Specialities = specialityService.findAll();
            model.addAttribute("professionalSpecialityList", Specialities);
            return "medicalProfessional/edit";
        }
        medicalProfessional = medicalProfessionalService.save(medicalProfessional);
        return "redirect:/medicalProfessionals";
    }

    @RequestMapping(value="/medicalProfessional/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Long id, Model model){
        model.addAttribute("medicalProfessional", medicalProfessionalService.findOne(id));
        List<Speciality> Specialities = specialityService.findAll();
        model.addAttribute("professionalSpecialityList", Specialities);
        return "medicalProfessional/edit";
    }

    @RequestMapping(value="/medicalProfessional/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id, Model model){
        medicalProfessionalService.delete(id);
        return "redirect:/medicalProfessionals";
    }
}

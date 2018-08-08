package com.OMS.ClinicProject.controller;

import com.OMS.ClinicProject.model.Allergy;
import com.OMS.ClinicProject.service.AllergyService;
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
public class AllergyController {
    @Autowired
    private AllergyService allergyService;

    @RequestMapping(value="/allergies", method = RequestMethod.GET)
    public ModelAndView allergies() {
        List<Allergy> allergies = allergyService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allergies", allergies);
        modelAndView.setViewName("Allergy/allergyList");
        return modelAndView;
    }
    @RequestMapping(value="/Allergy", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("allergy", new Allergy());
        return "Allergy/edit";
    }

    @RequestMapping(value = "/Allergy", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("allergy") Allergy allergy,
                       BindingResult result, Model model)  {

        if (result.hasErrors()) {
            model.addAttribute("errors", result.getAllErrors());
            return "Allergy/edit";
        }
        allergy = allergyService.save(allergy);
        return "redirect:/allergies";
    }

    @RequestMapping(value="/Allergy/{id}", method = RequestMethod.GET)
    public String view(@PathVariable Long id, Model model){
        model.addAttribute("allergy", allergyService.findOne(id));
        return "Allergy/edit";
    }

    @RequestMapping(value="/Allergy/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Long id, Model model){
        allergyService.delete(id);
        return "redirect:/allergies";
    }
}

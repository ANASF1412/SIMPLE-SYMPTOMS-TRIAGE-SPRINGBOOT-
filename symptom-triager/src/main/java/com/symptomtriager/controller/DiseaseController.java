package com.symptomtriager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.symptomtriager.model.Disease;
import com.symptomtriager.service.DiseaseService;

@Controller
public class DiseaseController {

    @Autowired
    private DiseaseService diseaseService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/check")
    public String checkSymptoms(@RequestParam("symptoms") String symptoms, Model model) {
        List<Disease> matchingDiseases = diseaseService.findBySymptoms(symptoms);
        model.addAttribute("diseases", matchingDiseases);
        model.addAttribute("symptoms", symptoms);
        return "results";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        List<Disease> diseases = diseaseService.findAll();
        model.addAttribute("diseases", diseases);
        model.addAttribute("disease", new Disease());
        return "admin";
    }

    @PostMapping("/admin/add")
    public String addDisease(@ModelAttribute Disease disease) {
        diseaseService.save(disease);
        return "redirect:/admin";
    }

    @PostMapping("/admin/update")
    public String updateDisease(@ModelAttribute Disease disease) {
        diseaseService.save(disease);
        return "redirect:/admin";
    }

    @PostMapping("/admin/delete/{id}")
    public String deleteDisease(@PathVariable Long id) {
        diseaseService.deleteById(id);
        return "redirect:/admin";
    }

    @GetMapping("/admin/edit/{id}")
    public String editDisease(@PathVariable Long id, Model model) {
        Disease disease = diseaseService.findById(id);
        List<Disease> diseases = diseaseService.findAll();
        model.addAttribute("disease", disease);
        model.addAttribute("diseases", diseases);
        return "admin";
    }
}

package de.tekup.locationappb.controllers;

import de.tekup.locationappb.services.VoitureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/voitures/ui")
@AllArgsConstructor
public class ViewVoitureCtrl {
    private VoitureService voitureService;
    @GetMapping("/")
    public String displayCars(Model model){
        model.addAttribute("voitures",voitureService.getAllVoitures());
        return "car";
    }
}

package de.tekup.locationappb.controllers;


import de.tekup.locationappb.entites.Voiture;
import de.tekup.locationappb.services.VoitureService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class VoitureCtrl {

    private VoitureService voitureService;
    @PostMapping("/voitures/save")
    @ResponseBody
    public Voiture saveVoiture(@RequestBody Voiture voiture){
        return voitureService.insertIntoDB(voiture);
    }
    @GetMapping("/voitures")
    @ResponseBody
    public List<Voiture> getAllVoitures(){
        return voitureService.getAllVoitures();
    }

    @GetMapping("/voitures/{id}")
    @ResponseBody
    public Voiture getVoitureById(@PathVariable("id") int voitureId){
        return voitureService.getVoitureById(voitureId);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String handleIllegalArgumentException(IllegalArgumentException e ){
        return e.getMessage();
    }
}

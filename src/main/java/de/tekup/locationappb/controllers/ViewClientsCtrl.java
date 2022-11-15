package de.tekup.locationappb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clients/ui")
public class ViewClientsCtrl {
    @GetMapping("/display")
    public String displayClients(){
        return "clients-display";
    }
}

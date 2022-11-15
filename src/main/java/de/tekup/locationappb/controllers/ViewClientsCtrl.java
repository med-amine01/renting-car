package de.tekup.locationappb.controllers;

import de.tekup.locationappb.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clients/ui")
@AllArgsConstructor
public class ViewClientsCtrl {

    private ClientService clientService;

    @GetMapping("/display")
    public String displayClients(Model model){
        model.addAttribute("clients",clientService.getAll());
        return "clients-display";
    }
}

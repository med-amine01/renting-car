package de.tekup.locationappb.controllers;

import de.tekup.locationappb.entites.Client;
import de.tekup.locationappb.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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

    @GetMapping("/add")
    public String addClients(Model model){
        model.addAttribute("client",new Client());
        return "clients-add";
    }

    @PostMapping("/add")
    public String addClientsPost(@Valid @ModelAttribute("client") Client client
                                , BindingResult result){
        if (result.hasErrors()){
            return "clients-add";
        }
        clientService.saveClient(client);
        return "redirect:/clients/ui/display";
    }
}

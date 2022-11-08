package de.tekup.locationappb.controllers;

import de.tekup.locationappb.entites.Client;
import de.tekup.locationappb.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class ClientCtrl {

    private ClientService clientService;

    @RequestMapping(path = "/clients/add",method = RequestMethod.POST)
    @ResponseBody
    public Client saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }

    @RequestMapping(path = "/clients/all",method = RequestMethod.GET)
    @ResponseBody
    public List<Client> getClients(){
        return clientService.getAll();
    }

    //@RequestMapping(path = "/clients/{id}",method = RequestMethod.GET)
    @GetMapping("/clients/{id}")
    @ResponseBody
    public Client getClientById(@PathVariable("id") int clientId){
       return clientService.getClientById(clientId);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public String handleIllegalArgsException(IllegalArgumentException e){
        return "Error in search :"+e.getMessage();
    }
}

package de.tekup.locationappb.controllers;

import de.tekup.locationappb.entites.Client;
import de.tekup.locationappb.entites.Voiture;
import de.tekup.locationappb.services.VoitureService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/voitures/ui")
@AllArgsConstructor
public class ViewVoitureCtrl {
    private VoitureService voitureService;
//    @GetMapping("/")
//    public String displayCars(Model model){
//        model.addAttribute("voitures",voitureService.getAllVoitures());
//        return "car";
//    }
    @GetMapping("/")
    public String displayAllCarsByPage(Model model,@RequestParam("page") Optional<Integer> page,
                                       @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(6);
        Page<Voiture> voiturePage = voitureService.getPageVoitures(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("voiturePage", voiturePage);

        int totalPages = voiturePage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "car";
    }

    @GetMapping("/add")
    public String ajouterVoiture(Model model){
        model.addAttribute("voiture",new Voiture());
        model.addAttribute("update",false);
        return "voitures-add";
    }

    @PostMapping("/add")
    public String addVoiturePost(@Valid @ModelAttribute("voiture") Voiture voiture
            , BindingResult result){
        if (result.hasErrors()){
            return "voitures-add";
        }
        voitureService.insertIntoDB(voiture);
        return "redirect:/voitures/ui/display";
    }
}

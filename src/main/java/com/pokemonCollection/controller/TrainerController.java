package com.pokemonCollection.controller;

import com.pokemonCollection.request.TrainerRequest;
import com.pokemonCollection.service.TrainerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TrainerController {
    private TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping("/trainer")
    public String trainer(){
        return "trainer";
    }

    @PostMapping("trainer-send")
    public String createTrainer(String name,String pokemon){    //TODO umozliwic dodawanie globalnych danych do kazdej strony w celu ukrycia linkow
        System.out.println("name "+name);
        System.out.println("pokemon "+pokemon);
        TrainerRequest trainerRequest=new TrainerRequest(name,pokemon);
        trainerService.createTrainer(trainerRequest);
        return "login-success";
    }

    @GetMapping("edit-trainer")
    public String editTrainer(int id,Model model){
        model.addAttribute("id", id);
        System.out.println(id);
        return "edit-trainer";
    }

    @PostMapping("/show-trainers")
    public String showTrainers(Model model){

        model.addAttribute("trainers",trainerService.getTrainers());
        return "login-success";
    }
    @PostMapping("/edit-trainers")
    public String editTrainers(int id,String name,String pokemon){
        trainerService.editTrainer(id,name,pokemon);

        return "login-success";
    }

}

package com.pokemonCollection.controller;

import com.pokemonCollection.service.BoosterService;
import com.pokemonCollection.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoosterController {
        private BoosterService boosterService;

    public BoosterController(BoosterService boosterService) {
        this.boosterService = boosterService;
    }

    @GetMapping("/booster")
        public String booster(){

            return "booster";
        }

    @GetMapping("card")
    public String card(){
        return "card";
    }

        @PostMapping("/booster-send")
        public String boosterSend(Model model){

            model.addAttribute("wylosowaneKarty",boosterService.losujKarty());
            return "booster-success";
        }

}

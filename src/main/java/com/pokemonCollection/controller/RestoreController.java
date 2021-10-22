package com.pokemonCollection.controller;

import com.pokemonCollection.request.RestoreRequest;
import com.pokemonCollection.service.RestoreService;
import com.pokemonCollection.service.UserServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RestoreController {

    private RestoreService restoreService;


    public RestoreController(RestoreService restoreService) {
        this.restoreService = restoreService;
    }


    @GetMapping("restore-password")
    public String restorePassword(){
        return "restore-password";

    }



    @PostMapping("/restore-password")
    public String restoreSend(String email, String securityCode, Model model){
        RestoreRequest restoreRequest=new RestoreRequest(email,securityCode);
        System.out.println(restoreRequest);

        try{

            restoreService.checkData(restoreRequest);


        }catch (UserServiceException e){

            model.addAttribute("errorMassage",e.getMessage());
            return "error";
        }

        //changingEmail=email;
        model.addAttribute("email", email);
        return "change-password";
    }
    @PostMapping("/change-send")
    public String changePassword( String password1,String password2,Model model,String email){

        System.out.println(email);
        try {
            restoreService.replacePassword(email,password1,password2);
        }catch (UserServiceException e){
            model.addAttribute("errorMassage",e.getMessage());
            return "error";
        }
        return "login";
    }


    /*
    @GetMapping("/change-password")
    public String changePassword(){

        return "change-password";
    }*/




}

package com.pokemonCollection.controller;

import com.pokemonCollection.request.UserRequest;
import com.pokemonCollection.service.UserService;
import com.pokemonCollection.service.UserServiceException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {


    private UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;

    }


    @GetMapping("/register")
    public String registerPage(){

        return "register";
    }
/*
    @PostMapping("/register-send")
    public String registerAccount(String email,String password1,String password2){
        UserRequest userRequest=new UserRequest(email,password1,password2);

        userService.rejestracjaUzytkownika(userRequest);
        return "register-success";
    }*/

    @PostMapping("/register-send")
    public String registerAccount(String email, String password1, String password2, Model model){
        UserRequest userRequest=new UserRequest(email,password1,password2);


        try {
            userService.rejestracjaUzytkownika(userRequest);
        }catch (UserServiceException e){
            model.addAttribute("errorMassage",e.getMessage());
            return "error";
        }


        return "register-success";
    }


    @GetMapping("/register-success")
    public String registerSuccess(){
        return "register-success";
    }

}

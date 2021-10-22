package com.pokemonCollection.controller;

import com.pokemonCollection.request.UserRequest;
import com.pokemonCollection.service.UserService;
import com.pokemonCollection.service.UserServiceException;
import org.apache.logging.log4j.message.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {


    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }


    @PostMapping("/login-send")
    public String loginAccount(String email, String password, Model model){
        System.out.println(email);
        System.out.println(password);
        UserRequest userRequest=new UserRequest(email,password);
        try {
            userService.loginUser(userRequest);
            //showDataOnSite(email);

        }catch (UserServiceException e){
            //e.getMessage();
            System.out.println(e.getMessage());
            model.addAttribute("errorMassage",e.getMessage());
            return "error";

        }
        model.addAttribute("email",email);
        return "login-success";
    }


    @GetMapping("login-successs2")
    public String loggedIn()
    {

        return "login-success2";
    }

    public ModelAndView showDataOnSite(String email){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("login-success");
        modelAndView.addObject("login", email);
        return  modelAndView;

    }
    @GetMapping("newfile")
    public String newFile(){
        return "newfile";
    }
    @GetMapping("newfile2")
    public String newFile2(){
        return "newfile2";
    }
    @GetMapping("template")
    public String template(){
        return "template";
    }
    @GetMapping("/")
    public String index(){
        return "index";
    }

    /*
    @PostMapping("/login-send")
    public ModelAndView loginAccount(String email, String password, HttpServletRequest request, HttpServletResponse response){


        UserRequest userRequest=new UserRequest(email,password);
        ModelAndView modelAndView=new ModelAndView();
        try {
            userService.loginUser(userRequest);
            modelAndView.setViewName("login-success.jsp");
            modelAndView.addObject("login", email);

        }catch (UserServiceException e){

            return modelAndView;
        }
        return modelAndView;
    }
*/


}

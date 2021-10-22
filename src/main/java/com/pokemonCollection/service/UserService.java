package com.pokemonCollection.service;

import com.pokemonCollection.model.User;
import com.pokemonCollection.repository.TrainerRepository;
import com.pokemonCollection.repository.UserRepository;
import com.pokemonCollection.request.UserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    private User loggedUser;
    private TrainerRepository trainerRepository;

    public UserService(UserRepository userRepository, TrainerRepository trainerRepository) {
        this.userRepository = userRepository;
        this.trainerRepository = trainerRepository;
    }

    public void rejestracjaUzytkownika(UserRequest userRequest){
        System.out.println(userRequest);

        User searchedAccount= userRepository.findByEmail(userRequest.getEmail());


        if(searchedAccount!=null){
            System.out.println("account exists");
            throw new UserServiceException("account exists");
        }
        if(!userRequest.getPassword1().equals(userRequest.getPassword2())){ //dlaczego equals dla stringa

            System.out.println("bledne haslo");
            throw new UserServiceException("passwords do not match");

        }else {
            createAccount(userRequest);
        }

    }


    public void createAccount(UserRequest userRequest){
        User account=new User(userRequest.getEmail(), userRequest.getPassword1());
        //saveAccountInDataBase(account);
        trainerRepository.save(account.getTrainer());
        userRepository.save(account);

        showAccount(account.getEmail());
    }

    public void showAccount(String email){
        System.out.println( userRepository.findByEmail(email));
    }



    public void loginUser(UserRequest userRequest){

        User searchedAccount= userRepository.findByEmail(userRequest.getEmail());


        if( null==searchedAccount){
           throw new UserServiceException("account email not found");
        }
        else if(userRequest.getPassword1().equals(searchedAccount.getPassword())){
            System.out.println("welcome "+searchedAccount.getEmail());
            loggedUser=searchedAccount;

        }else {

            throw new UserServiceException("wrong password");
        }
    }

    public User getLoggedUser() {
        return loggedUser;
    }


    /*
    @GetMapping("register-success")
    public String registerSuccess(){
        return "register-success";
    }*/
}

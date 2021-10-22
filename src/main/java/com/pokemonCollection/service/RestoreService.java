package com.pokemonCollection.service;

import com.pokemonCollection.controller.RestoreController;
import com.pokemonCollection.model.User;
import com.pokemonCollection.repository.UserRepository;
import com.pokemonCollection.request.RestoreRequest;
import org.springframework.stereotype.Service;

@Service
public class RestoreService {

    private UserRepository userRepository;

    public RestoreService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void checkData(RestoreRequest restoreRequest) {
        System.out.println(restoreRequest.getEmail());
        User searchedUser = userRepository.findByEmail(restoreRequest.getEmail());

        System.out.println(searchedUser);
        if (searchedUser == null) {
            System.out.println("account not found");
            throw new UserServiceException("account not found");
        }
        if (restoreRequest.getSecurityCode().equals("abc")) {

            System.out.println("security code accepted, change your password");


        } else throw new UserServiceException("wrong security code");

    }

    public void replacePassword(String email, String newPassword1, String newPassword2) {
        if (!newPassword1.equals(newPassword2)) {
            throw new UserServiceException("passwords are different");
        }
        System.out.println("email" + email);
        User searchedUser = userRepository.findByEmail(email);
        searchedUser.setPassword(newPassword1);

        userRepository.save(searchedUser);

        System.out.println(userRepository.findByEmail(email));


    }


}

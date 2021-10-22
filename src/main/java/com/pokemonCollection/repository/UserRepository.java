package com.pokemonCollection.repository;

import com.pokemonCollection.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User,Integer>{

    public User findByEmail(String email);
    public User findByPassword(String password);


}

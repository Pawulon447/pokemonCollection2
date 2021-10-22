package com.pokemonCollection.repository;

import com.pokemonCollection.model.Trainer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Integer> {
    public Trainer findByName(String name);
    public Trainer findById(int id);

}

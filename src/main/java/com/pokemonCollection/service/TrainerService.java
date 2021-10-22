package com.pokemonCollection.service;

import com.pokemonCollection.model.Trainer;
import com.pokemonCollection.repository.TrainerRepository;
import com.pokemonCollection.request.TrainerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerService {

    private TrainerRepository trainerRepository;

    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    public void createTrainer(TrainerRequest trainerRequest){
        System.out.println(trainerRequest);
        Trainer trainer=new Trainer(trainerRequest.getName(),trainerRequest.getPokemon());
        trainerRepository.save(trainer);


          /*
        Trainer searchedTrainer=trainerRepository.findByName(trainerRequest.getName());

        if (searchedTrainer!=null){
            throw new UserServiceException("trainer with this name exists");
        }*/
    }
    public List<Trainer> getTrainers(){
        List<Trainer> trainers=trainerRepository.findAll();
        System.out.println();
        trainers.forEach(System.out::println);

        return trainers;
    }
    public void editTrainer(int id, String name, String pokemon){
            Trainer searchedTrainer=trainerRepository.findById(id);
            if (searchedTrainer==null){
                throw new UserServiceException(" not found");

            }else {
                searchedTrainer.setName(name);
                searchedTrainer.setPokemon(pokemon);
                trainerRepository.save(searchedTrainer);
                System.out.println(trainerRepository.findById(id));
            }

    }
}

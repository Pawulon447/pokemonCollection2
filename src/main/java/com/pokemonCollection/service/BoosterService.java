package com.pokemonCollection.service;

import com.pokemonCollection.model.Card;
import com.pokemonCollection.model.Trainer;
import com.pokemonCollection.repository.CardRepository;
import com.pokemonCollection.repository.TrainerRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BoosterService {
   private CardRepository cardRepository;
    private UserService userService;
    private TrainerRepository trainerRepository;

    public BoosterService(CardRepository cardRepository, UserService userService, TrainerRepository trainerRepository) {
        this.cardRepository = cardRepository;
        this.userService = userService;
        this.trainerRepository = trainerRepository;
    }

    @PostConstruct
    public void createCardPool(){
        if( cardRepository.count()!=0){

          return;

        }  /* List<Card> cards=new ArrayList<>();
        cards.add(new Card("1"));
        cards.add(new Card("2"));
        cards.add(new Card("3"));
        cards.add(new Card("4"));
        cards.add(new Card("5"));
        cards.add(new Card("6"));
        cards.add(new Card("7"));
        cards.add(new Card("8"));
        cards.add(new Card("9"));
        cards.add(new Card("10"));
        cardRepository.saveAll(cards); */ //TODO przerobic na pobieranie kart z internetu
        //fadf6d3f-f910-4584-ab27-2268b6dcb2b2
    }
    public List<Card> losujKarty(){ //losujemy 5 kart dodajemy je do trenera i zwracamy
        List<Card> cards= cardRepository.findAll();
        Random random=new Random();
        List<Card> pickedCards=new ArrayList<>();
        for(int i=0;i< 5;i++){
            pickedCards.add(cards.get(random.nextInt(cards.size())));

        }
        Trainer usedTrainer=userService.getLoggedUser().getTrainer();
        usedTrainer.addCards(pickedCards);
        trainerRepository.save(usedTrainer);
        return pickedCards;
    }


}

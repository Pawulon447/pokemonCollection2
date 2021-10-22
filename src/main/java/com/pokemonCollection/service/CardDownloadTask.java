package com.pokemonCollection.service;

import com.pokemonCollection.model.Card;
import com.pokemonCollection.model.CardResponse;
import com.pokemonCollection.model.CardsResponse;
import com.pokemonCollection.repository.CardRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

public class CardDownloadTask implements Runnable{
    private RestTemplate restTemplate;
    private CardRepository cardRepository;
    private int i;
    private HttpEntity<String> entity;
    private boolean[] registry;

    public CardDownloadTask(RestTemplate restTemplate, CardRepository cardRepository, int i, HttpEntity<String> entity, boolean[] registry) {
        this.restTemplate = restTemplate;
        this.cardRepository = cardRepository;
        this.i = i;
        this.entity = entity;
        this.registry = registry;
    }

    @Override
    public void run() {
        if (registry[i]){
            System.out.println("task nr"+i +" was succesful");
            return;
        }
        ResponseEntity<CardsResponse> cardsResponseEntity = restTemplate.exchange("https://api.pokemontcg.io/v2/cards/?pageSize=250&page="+i+1, HttpMethod.GET, entity, CardsResponse.class);
        CardsResponse cardsResponse = cardsResponseEntity.getBody();

        List<CardResponse> data = cardsResponse.getData();
        List<Card> cards = new ArrayList<>();
        for (
                int j = 0; j < data.size(); j++) {
            Card card = new Card(data.get(j));

            cards.add(card);

        }
        cardRepository.saveAll(cards);

        //cardRepository.saveAll(cardsResponse.getImage());
        registry[i]=true;

        System.out.println("task "+i + " has been completed ");
    }
}

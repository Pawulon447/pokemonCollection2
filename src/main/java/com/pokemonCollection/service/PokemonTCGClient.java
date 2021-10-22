package com.pokemonCollection.service;

import com.pokemonCollection.repository.CardRepository;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Random;

@Service
public class PokemonTCGClient {

    private RestTemplate restTemplate;
    private CardRepository cardRepository;

    public PokemonTCGClient(RestTemplate restTemplate, CardRepository cardRepository) {
        this.restTemplate = restTemplate;
        this.cardRepository = cardRepository;
    }


    public void beginDownloading(){
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                try {
                    downloadCards();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread=new Thread(runnable);
        thread.start();
    }


    //spring po stworzeniu obiektu wywola ta metode
    public void downloadCards() throws InterruptedException {

        //Set the headers you need send
        final HttpHeaders headers = new HttpHeaders();
         headers.set("X-Api-Key", "fadf6d3f-f910-4584-ab27-2268b6dcb2b2");


        //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<>(headers);

        //Execute the method writing your HttpEntity to the request
        boolean[] registry=new boolean[57];
        int counter=0;
        Thread[] threads = new Thread[57];

        while(!isRegistryAllTrue(registry)) {
            counter++;
            System.out.println("counter "+counter);
            for (int i = 0; i < 56; i++) {
                threads[i] = new Thread(new CardDownloadTask(restTemplate, cardRepository, i, entity, registry));
                threads[i].start();
            }
            for (int i = 0; i < 56; i++) {
                threads[i].join();
            }

        }
        //TODO wykonac probne zapytanie o karty
        //przygotuj strone wystawiania kart i kupowania wystawionych

    }

    private boolean isRegistryAllTrue(boolean[] registry){
        for (int i=0;i<56;i++){
            if(!registry[i]){
                return false;
            }

        }
        return true;
    }


    private void method() {
        class LocalClass{

        }
        LocalClass localClass = new LocalClass();


        Random random = new Random(){
            @Override
            public int nextInt() {
                return 9;
            }
        };

        System.out.println(random.nextInt());
    }


    class InnerClass{

    }

}

class PackageClass{

}

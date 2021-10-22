package com.pokemonCollection.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trainer {
    @Id
    @GeneratedValue
   private int id;
   private String name;
   private String pokemon;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Card> cardList=new ArrayList<>();

    public Trainer(String name, String pokemon) {
        this.name = name;
        this.pokemon = pokemon;
    }

    public Trainer() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPokemon() {
        return pokemon;
    }

    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
    }

    public int getId() {
        return id;
    }

    public List<Card> getCardList() {
        return new ArrayList<>(cardList);
    }
    public void addCards(List<Card>cardList2){
        cardList.addAll(cardList2);
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pokemon='" + pokemon + '\'' +
                '}';
    }
}

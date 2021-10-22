package com.pokemonCollection.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Card {
    @Id
    private String id;
    private String name;
    private String small;
    private String large;
    public Card(String name) {
        this.name = name;
    }

    public Card() {
    }
    public Card(CardResponse cardResponse){
        id=cardResponse.getId();
        name=cardResponse.getName();
        small=cardResponse.getImages().getSmall();
        large=cardResponse.getImages().getLarge();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getSmall() {
        return small;
    }

    public String getLarge() {
        return large;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

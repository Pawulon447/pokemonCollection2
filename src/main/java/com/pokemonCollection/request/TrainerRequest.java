package com.pokemonCollection.request;

public class TrainerRequest {
    private String name;
    private String pokemon;

    public TrainerRequest(String name, String pokemon) {
        this.name = name;
        this.pokemon = pokemon;
    }

    public TrainerRequest() {
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

    @Override
    public String toString() {
        return "TrainerRequest{" +
                "name='" + name + '\'' +
                ", pokemon='" + pokemon + '\'' +
                '}';
    }
}

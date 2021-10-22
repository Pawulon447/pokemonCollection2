package com.pokemonCollection.model;

import javax.persistence.Id;

public class CardResponse {

    private String id;
    private String name;
    private ImageResponse images;

    public CardResponse() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ImageResponse getImages() {
        return images;
    }
}

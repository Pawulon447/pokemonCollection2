package com.pokemonCollection.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.awt.*;
import java.sql.Blob;
import java.util.List;


public class CardsResponse {


    private List<CardResponse> data;
    private int totalCount;
    public CardsResponse(List<CardResponse> data) {
        this.data = data;

        ;
    }

    public CardsResponse() {
    }

    public List<CardResponse> getData() {
        return data;
    }

    public int getTotalCount() {
        return totalCount;
    }

    @Override
    public String toString() {
        return "CardsResponse{" +
                "data=" + data +
                '}';
    }
}

package com.congapp.ShelterInv.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    

    private String name;
    private double price;
    private UUID id;

    public Item(@JsonProperty("name")  String name, 
                @JsonProperty("price")  double price,
                @JsonProperty("id")  UUID id){
        this.name = name;
        this.price = price;
        this.id = id;
        this.id = UUID.randomUUID();
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return price;
    }
    
    public void setPrice(double price){
        this.price = price;
    }

    public UUID getId(){
        return id;
    }

}

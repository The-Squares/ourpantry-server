package com.congapp.ShelterInv.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    

    private String name;
    private int quantity;

    public Item(@JsonProperty("name")  String name, 
                @JsonProperty("quantity")  int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addQuant(){
        quantity += 1;
    }

    public void minQuant(){
        quantity -= 1;
    }
}

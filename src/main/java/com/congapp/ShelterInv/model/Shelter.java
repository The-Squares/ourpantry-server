package com.congapp.ShelterInv.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Shelter {
    
    private final UUID id;
    private final String name;
    private List<Item> offers = new ArrayList<>();

    public Shelter (@JsonProperty("id") UUID id, 
                   @JsonProperty("name") String name){
        this.id = id;
        this.name = name;
    }

    public UUID getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public void addItem(Item item){
        offers.add(item);
    }

    public void removeItemByID(UUID id){
        for (int i = 0; i < offers.size(); i++){
            if (offers.get(i).getId().equals(id)) offers.remove(i);
        }
    }

    public Item getItemByID(UUID id){
        for (int i = 0; i < offers.size(); i++){
            if (offers.get(i).getId().equals(id)) return offers.get(i);
        }
        return null;
    }

    public List<Item> getOffers(){
        return offers;
    }
    
}

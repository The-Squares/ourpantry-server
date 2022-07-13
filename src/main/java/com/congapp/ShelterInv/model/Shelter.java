package com.congapp.ShelterInv.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Shelter {
    
    private final UUID id;
    private final String name;
    private final String email;
    private final String address;
    private final String password;
    private List<Item> offers = new ArrayList<>();

    public Shelter (@JsonProperty("id") UUID id, 
                   @JsonProperty("name") String name,
                   @JsonProperty("email") String email,
                   @JsonProperty("address") String address,
                   @JsonProperty("password") String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public UUID getId(){
        return id;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getPassword() { return password; }

    public void addItem(Item item){
        offers.add(item);
    }

    public void removeItemByName(String name){
        for (int i = 0; i < offers.size(); i++){
            if (offers.get(i).getName().equals(name)) offers.remove(i);
        }
    }

    public Item getItemByName(String name){
        for (int i = 0; i < offers.size(); i++){
            if (offers.get(i).getName().equals(name)) return offers.get(i);
        }
        return null;
    }

    public List<Item> getOffers(){
        return offers;
    }
    
}

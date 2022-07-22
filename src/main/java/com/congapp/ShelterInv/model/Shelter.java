package com.congapp.ShelterInv.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;


@Document("shelter")
public class Shelter {
    
    @Id
    private String id;
    private String name;
    @Indexed(unique = true) private String email;
    private String address;
    private String password;

    private List<Item> offers = new ArrayList<>();

    public Shelter (String name,
                    String email,
                    String address,
                    String password){
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
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

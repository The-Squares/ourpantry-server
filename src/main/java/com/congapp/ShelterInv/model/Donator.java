package com.congapp.ShelterInv.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document
public class Donator {
    
    @Id
    private String id;
    private String name;
    private String email;
    private String password;

    public Donator (String name,
                   String email,
                   String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String getEmail() { return email; }
    public String getPassword() { return password; }

}

 
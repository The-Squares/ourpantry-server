package com.congapp.ShelterInv.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Donator {
    
    private final UUID id;
    private String name;
    private String email;
    private String password;

    public Donator (@JsonProperty("id") UUID id, 
                   @JsonProperty("name") String name,
                   @JsonProperty("email") String email,
                   @JsonProperty("password") String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UUID getId(){
        return id;
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

 
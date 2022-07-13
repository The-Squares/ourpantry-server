package com.congapp.ShelterInv.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    
    private final UUID id;
    private String name;
    private double balance;

    public Customer (@JsonProperty("id") UUID id, 
                   @JsonProperty("name") String name,
                   @JsonProperty("balance") double balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
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

    public double getBalance(){
        return balance;
    }
    
    // public void setBalance(double balance){
    //     this.balance = balance;
    // }
    
    public void addBalance(double balance){
        this.balance += balance;
    }

    public void subBalance(double balance){
        this.balance -= balance;
    }
}

 
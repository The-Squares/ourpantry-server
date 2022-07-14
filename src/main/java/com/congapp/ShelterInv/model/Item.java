package com.congapp.ShelterInv.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    

    private String name;
    private int quantity;

    public enum Level {
        LOW,
        MEDIUM,
        HIGH
    }

    private Level priority;
      

    public Item(@JsonProperty("name")  String name, 
                @JsonProperty("quantity")  int quantity,
                @JsonProperty("priority")  int priority){
        this.name = name;
        this.quantity = quantity;

        if (priority == 2) this.priority = Level.MEDIUM; 
            else if (priority == 3) this.priority = Level.HIGH; 
                else this.priority = Level.LOW;
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

    public Level getPriority(){
        return priority;
    }

    public void setPriority(int priority){
        if (priority == 2) this.priority = Level.MEDIUM; 
            else if (priority == 3) this.priority = Level.HIGH; 
                else this.priority = Level.LOW;
    }
}

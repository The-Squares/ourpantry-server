package com.congapp.ShelterInv.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    

    private String name;
    private int quantity;

    public enum Level {
        LOW,
        MEDIUM,
        HIGH,
        NONE
    }

    private Level priority;
      

    public Item(String name, 
                int quantity,
                int priority){
        this.name = name;
        this.quantity = quantity;

        if (priority == 1) this.priority = Level.LOW;
            else if (priority == 2) this.priority = Level.MEDIUM; 
                else if (priority == 3) this.priority = Level.HIGH;
                    else this.priority = Level.NONE;
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
        if (priority == 1) this.priority = Level.LOW;
            else if (priority == 2) this.priority = Level.MEDIUM; 
                else if (priority == 3) this.priority = Level.HIGH;
                    else this.priority = Level.NONE;
    }
}

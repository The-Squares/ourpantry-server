package com.congapp.ShelterInv.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Item {
    
    @Id
    private String id;
    
    private String name;
    private int quantity;
    private int priority;

    public Item(String name, 
                int quantity,
                int priority){
        this.name = name;
        this.quantity = quantity;
        this.priority = priority;
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

    public int getQuant(){
        return quantity;
    }

    public int getPriority(){
        return priority;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }
}

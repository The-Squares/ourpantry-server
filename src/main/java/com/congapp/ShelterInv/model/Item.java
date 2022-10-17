package com.congapp.ShelterInv.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Item {

    @Id
    private String id;

    private String name;
    private int quant;
    private int priority;

    public Item() {
        this.quant = 0;
    }

    public Item(String name, int quant, int priority) {
        this.name = name;
        this.quant = quant;
        this.priority = priority;
    }

    public String getName() {
        return name != null ? name : "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addQuant() {
        quant += 1;
    }

    public void minQuant() {
        quant -= 1;
    }

    public int getQuant() {
        return quant;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String toString() {
        return "Item[name=" + name + ", quantity=" + quant + ", priority=" + priority + "]";
    }
}

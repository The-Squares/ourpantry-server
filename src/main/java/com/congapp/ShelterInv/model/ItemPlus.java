package com.congapp.ShelterInv.model;

public class ItemPlus {
    private Item item;
    private String password;

    public ItemPlus(){
        item = new Item("name", 0, 0);
        password = "password";
    }

    public ItemPlus(Item item, String password){
        item = this.item;
        password = this.password;
    }

    public Item getItem(){
        return item;
    }

    public String getPassword(){
        return password;
    }
}

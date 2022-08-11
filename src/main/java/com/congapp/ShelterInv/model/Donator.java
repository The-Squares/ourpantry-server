package com.congapp.ShelterInv.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("donator")
public class Donator {
    
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
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

    public void setPassword(String password){
        this.password = password;
    }
    
    public String getEmail() { return email; }
    public String getPassword() { return password; }

}

 
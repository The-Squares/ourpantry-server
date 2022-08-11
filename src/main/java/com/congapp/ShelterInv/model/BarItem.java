package com.congapp.ShelterInv.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BarItem {
    private String name;

    @JsonProperty("brand_name")
    private String brandName;

    public BarItem(){
        name = "Default";
        brandName = "Default_Company";
    }

    public BarItem(String name, String brandName){
        this.name = name;
        this.brandName = brandName;
    }

    public String getName(){
        return name;
    }

    public String getBrandName(){
        return brandName;
    }

    public void setLongitude(String name){
        this.name = name;
    }

    public void setBrandName(String brandName){
        this.brandName = brandName;
    }
}

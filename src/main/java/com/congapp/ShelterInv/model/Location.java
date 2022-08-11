package com.congapp.ShelterInv.model;

public class Location {
    private float longitude;
    private float latitude;

    public Location(){
        longitude = 0;
        latitude = 0;
    }

    public Location(float longitude, float latitude){
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public float getLongitude(){
        return longitude;
    }

    public float getLatitude(){
        return latitude;
    }

    public void setLongitude(float longitude){
        this.longitude = longitude;
    }

    public void setLatitude(float latitude){
        this.latitude = latitude;
    }
}

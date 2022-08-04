package com.congapp.ShelterInv.dao;

public class Cords {

    double latitude;
    double longitude;

    public Cords (){
        this.latitude = 0;
        this.longitude = 0;
    }

    public Cords( double latitude, double longitude){

        this.latitude = latitude;
        this.longitude = longitude;

    }

    public double getLatitude(){
        return latitude;
    }

    public double getLongitude(){
        return longitude;
    }
}


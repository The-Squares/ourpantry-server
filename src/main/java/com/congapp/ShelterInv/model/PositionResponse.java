package com.congapp.ShelterInv.model;

import java.util.ArrayList;
import java.util.List;

public class PositionResponse {

    List<Location> data = new ArrayList<>();

    public PositionResponse (List<Location> data){
        this.data = data;
    }

    public PositionResponse(){
        data.add(new Location(0, 0));
    }

    public List<Location> getData(){
        return data;
    }
}

package com.congapp.ShelterInv.dao;

import java.util.ArrayList;
import java.util.List;

public class PositionResponse {

    List<Cords> data = new ArrayList<>();

    public PositionResponse (List<Cords> data){
        this.data = data;
    }

    public PositionResponse(){
        data.add(new Cords(0, 0));
    }

    public List<Cords> getData(){
        return data;
    }
}

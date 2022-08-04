package com.congapp.ShelterInv.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.geo.Point;


public class PositionResponse {

    List<Point> data = new ArrayList<>();

    public PositionResponse (List<Point> data){
        this.data = data;
    }

    public PositionResponse(){
        data.add(new Point(0, 0));
    }

    public List<Point> getData(){
        return data;
    }
}

package com.congapp.ShelterInv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;

import com.congapp.ShelterInv.dao.DonatorDao;
import com.congapp.ShelterInv.model.Donator;
import com.congapp.ShelterInv.model.Shelter;

@Service
public class DonatorService {

    private final DonatorDao donatorDao;

    @Autowired
    public DonatorService (@Qualifier("donDao") DonatorDao donatorDao){
        this.donatorDao = donatorDao;
    }
    
    public Donator addPerson (Donator donator){
        return donatorDao.insert(donator);
    }

    public List<Donator> getAllPeople(){
        return donatorDao.findAll();
    }

    public List<Shelter> findByDistance(float latitude, double longitude, int distance){
        Point baseCords = new Point (latitude, longitude);

        Distance radius = new Distance (distance, Metrics.MILES);

        Circle area = new Circle(baseCords, radius);

        Query query = new Query();
        query.addCriteria(Criteria.where("address.geoLocation").withinSphere(area));

        return MongoOperations.find(query, Shelter.class);

    public Optional<Donator> getPersonById(String id){
        return donatorDao.findById(id);
    }

    public void removePerson (String id){
        donatorDao.deleteById(id);
    }

    public void changePersonName (String id, String name){
        donatorDao.findById(id).get().setName(name);
    }

    public String getPassword (String id){
        return donatorDao.findById(id).get().getPassword();
    }

}

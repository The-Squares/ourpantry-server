package com.congapp.ShelterInv.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.congapp.ShelterInv.dao.ShelterDao;
import com.congapp.ShelterInv.model.Item;
import com.congapp.ShelterInv.model.Shelter;

@Service
public class ShelterService {

    private final ShelterDao shelterDao;

    @Autowired
    public ShelterService (@Qualifier("shelDao") ShelterDao shelterDao){
        this.shelterDao = shelterDao;
    }
    
    public Shelter addShelter (Shelter shelter){
        return shelterDao.insert(shelter);
    }

    public List<Shelter> getAllShelters(){
        return shelterDao.findAll();
    }

    public Optional<Shelter> getShelterById(String id){
        return shelterDao.findById(id);
    }

    public void removeShelter (String id){
        shelterDao.deleteById(id);
    }

    public List<Item> getItems(String id){
        return shelterDao.findById(id).get().getOffers();
    }

    public String getPassword (String id){
        return shelterDao.findById(id).get().getPassword();
    }

    public String getAddress(String id){
        return shelterDao.findById(id).get().getAddress();
    }

    public void addItem(String id, Item item){
        Shelter shelter = shelterDao.findById(id).get();
        shelter.addItem(item);
        shelterDao.save(shelter);
    }

    public void removeItem(String id, String iName){
        Shelter shelter = shelterDao.findById(id).get();
        shelter.removeItemByName(iName);
        shelterDao.save(shelter);
    }

    public void addQuant(String id, String iName){
        Shelter shelter = shelterDao.findById(id).get();
        shelter.getItemByName(iName).addQuant();
        shelterDao.save(shelter);
    }

    public void minQuant(String id, String iName){
        Shelter shelter = shelterDao.findById(id).get();
        shelter.getItemByName(iName).minQuant();
        shelterDao.save(shelter);
    }

    public int getPrior(String id, String iName){
        return shelterDao.findById(id).get().getItemByName(iName).getPriority();
    }

    public void changePrior(String id, String iName, int priority){
        Shelter shelter = shelterDao.findById(id).get();
        shelter.getItemByName(iName).setPriority(priority);
        shelterDao.save(shelter);
    }

    public List<Shelter> findByDistance(float latitude, double longitude, int distance){
        Point baseCords = new Point (latitude, longitude);

        Distance radius = new Distance (distance, Metrics.MILES);

        Circle area = new Circle(baseCords, radius);

        Query query = new Query();
        query.addCriteria(Criteria.where("address.geoLocation").withinSphere(area));

        return MongoOperations.find(query, Shelter.class);
    }

}

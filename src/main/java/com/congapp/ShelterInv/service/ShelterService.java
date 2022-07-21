package com.congapp.ShelterInv.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.congapp.ShelterInv.dao.ShelterDao;
import com.congapp.ShelterInv.model.Item;
import com.congapp.ShelterInv.model.Shelter;
import com.congapp.ShelterInv.model.Item.Level;

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

    public void addItem(String id, Item item){
        shelterDao.findById(id).get().addItem(item);
    }

    public void removeItem(String id, String iName){
        shelterDao.findById(id).get().removeItemByName(iName);
    }

    public void addQuant(String id, String iName){
        shelterDao.findById(id).get().getItemByName(iName).addQuant();
    }

    public void minQuant(String id, String iName){
        shelterDao.findById(id).get().getItemByName(iName).minQuant();;
    }

    public Level getPrior(String id, String iName){
        return shelterDao.findById(id).get().getItemByName(iName).getPriority();
    }

    public void changePrior(String id, String iName, int priority){
        shelterDao.findById(id).get().getItemByName(iName).setPriority(priority);
    }

}

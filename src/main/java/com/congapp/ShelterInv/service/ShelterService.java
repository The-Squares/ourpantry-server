package com.congapp.ShelterInv.service;

import java.util.List;
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
    
    public int addShelter (Shelter shelter){
        return shelterDao.insertShelter(shelter);
    }

    public List<Shelter> getAllShelters(){
        return shelterDao.selectAllShelters();
    }

    public Shelter getShelterById(UUID id){
        return shelterDao.selectShelterById(id);
    }

    public int removeShelter (UUID id){
        return shelterDao.deleteShelterById(id);
    }

    public List<Item> getItems(UUID id){
        return shelterDao.selectAllItems(id);
    }

    public int addItem(UUID id, Item item){
        return shelterDao.addShelterItem(id, item);
    }

    public int removeItem(UUID id, String iName){
        return shelterDao.removeShelterItem(id, iName);
    }

    public int addQuant(UUID id, String iName){
        return shelterDao.addItemQuant(id, iName);
    }

    public int minQuant(UUID id, String iName){
        return shelterDao.minItemQuant(id, iName);
    }

    public Level getPrior(UUID id, String iName){
        return shelterDao.getPriority(id, iName);
    }

    public int changePrior(UUID id, String iName, int priority){
        return shelterDao.changePriority(id, iName, priority);
    }

}

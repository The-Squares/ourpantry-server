package com.congapp.ShelterInv.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    public int addItem(UUID id, Item item){
        return shelterDao.addShelterItem(id, item);
    }

    public int removeItem(UUID id, UUID Iid){
        return shelterDao.removeShelterItem(id, Iid);
    }

}

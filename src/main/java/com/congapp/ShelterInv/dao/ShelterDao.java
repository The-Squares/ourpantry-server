package com.congapp.ShelterInv.dao;

import java.util.List;
import java.util.UUID;

import com.congapp.ShelterInv.model.Item;
import com.congapp.ShelterInv.model.Shelter;

public interface ShelterDao {
    
    int insertShelter(UUID id, Shelter shelter);

    default int insertShelter(Shelter shelter){
        UUID id = UUID.randomUUID();
        return insertShelter(id, shelter);
    }

    List<Shelter> selectAllShelters();

    Shelter selectShelterById(UUID id);

    int deleteShelterById(UUID id);

    int addShelterItem(UUID id, Item item);

    int removeShelterItem(UUID id, String iName);

    int addItemQuant (UUID id, String iName);

    int minItemQuant (UUID id, String iName);
}

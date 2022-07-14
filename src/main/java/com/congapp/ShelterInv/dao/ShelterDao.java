package com.congapp.ShelterInv.dao;

import java.util.List;
import java.util.UUID;

import com.congapp.ShelterInv.model.Item;
import com.congapp.ShelterInv.model.Shelter;
import com.congapp.ShelterInv.model.Item.Level;

public interface ShelterDao {
    
    int insertShelter(UUID id, Shelter shelter);

    default int insertShelter(Shelter shelter){
        UUID id = UUID.randomUUID();
        return insertShelter(id, shelter);
    }

    List<Shelter> selectAllShelters();

    Shelter selectShelterById(UUID id);

    int deleteShelterById(UUID id);

    List<Item> selectAllItems();

    int addShelterItem(UUID id, Item item);

    int removeShelterItem(UUID id, String iName);

    int addItemQuant (UUID id, String iName);

    int minItemQuant (UUID id, String iName);

    Level getPriority(UUID id, String iName);

    int changePriority(UUID id, String iName, int priority);
}

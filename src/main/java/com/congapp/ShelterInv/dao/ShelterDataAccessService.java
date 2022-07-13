package com.congapp.ShelterInv.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.congapp.ShelterInv.model.Item;
import com.congapp.ShelterInv.model.Shelter;

@Repository("shelDao")
public class ShelterDataAccessService implements ShelterDao{

    public static List<Shelter> DB = new ArrayList<>();
    
    @Override
    public int insertShelter (UUID id, Shelter shelter){
        DB.add(new Shelter(id, shelter.getName(), shelter.getEmail(), shelter.getAddress(), shelter.getPassword()));
        return 1;
    }

    @Override
    public List<Shelter> selectAllShelters(){
        return DB;
    }

    @Override
    public Shelter selectShelterById(UUID id) {
        for (Shelter shelter : DB){
            if (id.equals(shelter.getId())){
                return shelter;
            }
        }
        return null;
    }

    @Override
    public int deleteShelterById(UUID id) {
        if (selectShelterById(id) == null) return 0;
        DB.remove(selectShelterById(id));
        return 1;
    }

    @Override
    public int addShelterItem(UUID id, Item item) {
        if (selectShelterById(id) == null) return 0;
        selectShelterById(id).addItem(item);
        return 1;
    }

    @Override
    public int removeShelterItem(UUID id, String iName) {
        if (selectShelterById(id) == null) return 0;
        selectShelterById(id).removeItemByName(iName);
        return 1;
    }

    @Override
    public int addItemQuant(UUID id, String iName) {
        if (selectShelterById(id).getItemByName(iName) != null){
            selectShelterById(id).getItemByName(iName).addQuant(); return 1; }
        return 0;
    }

    @Override
    public int minItemQuant(UUID id, String iName) {
        if (selectShelterById(id).getItemByName(iName) != null){
            selectShelterById(id).getItemByName(iName).minQuant(); return 1; }
        return 0;
    }

}

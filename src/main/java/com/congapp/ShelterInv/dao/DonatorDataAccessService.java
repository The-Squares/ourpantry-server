package com.congapp.ShelterInv.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.congapp.ShelterInv.model.Donator;

@Repository("donDao")
public class DonatorDataAccessService implements DonatorDao{

    public static List<Donator> DB = new ArrayList<>();

    @Autowired
    private ShelterDataAccessService marketAccess;
    
    @Override
    public int insertPerson (UUID id, Donator person){
        DB.add(new Donator(id, person.getName(), person.getEmail(), person.getPassword()));
        return 1;
    }

    @Override
    public List<Donator> selectAllPeople(){
        return DB;
    }

    @Override
    public Donator selectPersonById(UUID id) {
        for (Donator person : DB){
            if (id.equals(person.getId())){
                return person;
            }
        }
        return null;
    }

    @Override
    public int deletePersonById(UUID id) {
        if (selectPersonById(id) == null) return 0;
        DB.remove(selectPersonById(id));
        return 1;
    }

    @Override
    public int updatePersonName(UUID id, String name) {
        if (DB.indexOf(selectPersonById(id)) < 0) return 0;
        selectPersonById(id).setName(name);
        return 1;
    }

}

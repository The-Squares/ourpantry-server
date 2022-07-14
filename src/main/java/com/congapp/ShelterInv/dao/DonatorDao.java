package com.congapp.ShelterInv.dao;

import java.util.List;
import java.util.UUID;

import com.congapp.ShelterInv.model.Donator;

public interface DonatorDao {
    
    int insertPerson(UUID id, Donator person);

    default int insertPerson(Donator person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Donator> selectAllPeople();

    Donator selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonName(UUID id, String name);

}


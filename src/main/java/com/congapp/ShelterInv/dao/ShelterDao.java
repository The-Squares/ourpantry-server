package com.congapp.ShelterInv.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.congapp.ShelterInv.model.Item;
import com.congapp.ShelterInv.model.Shelter;
import com.congapp.ShelterInv.model.Item.Level;

@Repository("shelDao")
public interface ShelterDao extends MongoRepository<Shelter, String> {
    
}

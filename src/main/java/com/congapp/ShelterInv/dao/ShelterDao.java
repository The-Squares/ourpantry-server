package com.congapp.ShelterInv.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.congapp.ShelterInv.model.Shelter;

@Repository("shelDao")
public interface ShelterDao extends MongoRepository<Shelter, String> {
    
}

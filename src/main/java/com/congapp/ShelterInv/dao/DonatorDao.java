package com.congapp.ShelterInv.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.congapp.ShelterInv.model.Donator;

@Repository("donDao")
public interface DonatorDao extends MongoRepository<Donator, String>{

}


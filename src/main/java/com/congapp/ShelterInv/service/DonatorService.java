package com.congapp.ShelterInv.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.congapp.ShelterInv.dao.DonatorDao;
import com.congapp.ShelterInv.model.Donator;

@Service
public class DonatorService {

    private final DonatorDao donatorDao;

    @Autowired
    public DonatorService (@Qualifier("donDao") DonatorDao donatorDao){
        this.donatorDao = donatorDao;
    }
    
    public int addPerson (Donator donator){
        return donatorDao.insertPerson(donator);
    }

    public List<Donator> getAllPeople(){
        return donatorDao.selectAllPeople();
    }

    public Donator getPersonById(UUID id){
        return donatorDao.selectPersonById(id);
    }

    public int removePerson (UUID id){
        return donatorDao.deletePersonById(id);
    }

    public int changePersonName (UUID id, String name){
        return donatorDao.updatePersonName(id, name);
    }

}

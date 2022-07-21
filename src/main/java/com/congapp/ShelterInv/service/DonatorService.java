package com.congapp.ShelterInv.service;

import java.util.List;
import java.util.Optional;

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
    
    public Donator addPerson (Donator donator){
        return donatorDao.insert(donator);
    }

    public List<Donator> getAllPeople(){
        return donatorDao.findAll();
    }

    public Optional<Donator> getPersonById(String id){
        return donatorDao.findById(id);
    }

    public void removePerson (String id){
        donatorDao.deleteById(id);
    }

    public void changePersonName (String id, String name){
        donatorDao.findById(id).get().setName(name);
    }

    public void getPassword (String id){
        donatorDao.findById(id).get().getPassword();
    }

}

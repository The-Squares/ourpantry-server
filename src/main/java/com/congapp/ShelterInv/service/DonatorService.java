package com.congapp.ShelterInv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;

import com.congapp.ShelterInv.dao.DonatorDao;
import com.congapp.ShelterInv.model.Donator;

@Service
public class DonatorService {

    private final DonatorDao donatorDao; 
    // private final PasswordEncoder passwordEncoder;

    @Autowired
    public DonatorService (@Qualifier("donDao") DonatorDao donatorDao){
        this.donatorDao = donatorDao;
        // passwordEncoder = new BCryptPasswordEncoder();
    }
    
    public Donator addPerson (Donator donator){
        // String password = passwordEncoder.encode(donator.getPassword());
        // donator.setPassword(password);
        return donatorDao.insert(donator);
    }

    public List<Donator> getAllPeople(){
        return donatorDao.findAll();
    }

    public Optional<Donator> getPersonById(String id){
        if (donatorDao.findById(id).isPresent()){
            return donatorDao.findById(id);
        }
        return null;
    }

    public void removePerson (String id){
        if (donatorDao.findById(id).isPresent()){
            donatorDao.deleteById(id);
        }
    }

    public void changePersonName (String id, String name){
        if (donatorDao.findById(id).isPresent()){
            donatorDao.findById(id).get().setName(name);
        }
    }

    public String getPassword (String id){
        if (donatorDao.findById(id).isPresent()){
            return donatorDao.findById(id).get().getPassword();
        }
        return null;
    }

}

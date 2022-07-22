package com.congapp.ShelterInv.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.congapp.ShelterInv.model.Donator;
import com.congapp.ShelterInv.service.DonatorService;

@RequestMapping("api/v1/customer")
@RestController
public class DonatorController {
    
    private final DonatorService personService;
    //private final MarketService marketService;

    @Autowired
    public DonatorController (DonatorService personService){
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Donator person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Donator> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Optional<Donator> getPersonByID(@PathVariable String id){
        return personService.getPersonById(id);
    }

    @DeleteMapping(path = "{id}")//User PSW
    public void removePerson(@PathVariable String id, @RequestBody String password){
        if (password.equals(personService.getPassword(id))) personService.removePerson(id);
    }

    @PutMapping(path = "{id}")//User PSW
    public void changePersonName(@PathVariable String id, @RequestParam String name, @RequestBody String password){
        if (password.equals(personService.getPassword(id))) personService.changePersonName(id, name);
    }

}
 
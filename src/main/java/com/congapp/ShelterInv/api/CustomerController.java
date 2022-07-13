package com.congapp.ShelterInv.api;

import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import org.yaml.snakeyaml.error.Mark;

import com.congapp.ShelterInv.model.Customer;
import com.congapp.ShelterInv.service.CustomerService;
import com.congapp.ShelterInv.service.ShelterService;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {
    
    private final CustomerService personService;
    //private final MarketService marketService;

    @Autowired
    public CustomerController (CustomerService personService){
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Customer person){
        personService.addPerson(person);
    }

    @GetMapping
    public List<Customer> getAllPeople(){
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Customer getPersonByID(@PathVariable UUID id){
        return personService.getPersonById(id);
    }

    @DeleteMapping(path = "{id}")
    public int removePerson(@PathVariable UUID id){
        return personService.removePerson(id);
    }

    @PutMapping(path = "{id}")
    public int changePersonName(@PathVariable UUID id, @RequestParam String name){
        return personService.changePersonName(id, name);
    }

    @PutMapping(path = "{id}/add")
    public int addPersonBalanceByID(@PathVariable UUID id, @RequestParam double amount){
        return personService.increaseBalanceById(id, amount);
    }

    @PutMapping(path = "{id}/sub")
    public int subPersonBalanceByID(@PathVariable UUID id, @RequestParam double amount){
        return personService.decreaseBalanceById(id, amount);
    }

    @PutMapping(path = "{id}/buy/{mID}")
    public int CustBuyItemByID(@PathVariable UUID id, @PathVariable UUID mID, @RequestParam UUID itemID){
        return personService.buyItemById(id, mID, itemID);
    }

}

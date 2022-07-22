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

import com.congapp.ShelterInv.model.Item;
import com.congapp.ShelterInv.model.Shelter;
import com.congapp.ShelterInv.service.ShelterService;

@RequestMapping("api/v1/shelter")
@RestController
public class ShelterController {
    
    private final ShelterService shelterService;

    @Autowired
    public ShelterController (ShelterService shelterService){
        this.shelterService = shelterService;
    }

    @PostMapping
    public void addShelter(@RequestBody Shelter shelter){
        shelterService.addShelter(shelter);
    }

    @GetMapping
    public List<Shelter> getAllShelters(){
        return shelterService.getAllShelters();
    }

    @GetMapping(path = "{id}")
    public Optional<Shelter> getShelterByID(@PathVariable String id){
        return shelterService.getShelterById(id);
    }

    @DeleteMapping(path = "{id}") //Shelter PSW
    public void removeShelter(@PathVariable String id, @RequestBody String password){
        if (password.equals(shelterService.getPassword(id))) shelterService.removeShelter(id);
    }

    @GetMapping(path = "{id}/item") //Shelter PSW
    public List<Item> getItemsByID(@PathVariable String id, @RequestBody Item item, @RequestBody String password){
        if (password.equals(shelterService.getPassword(id))) return shelterService.getItems(id);
        return null;
    }

    @PostMapping(path = "{id}/item") //Shelter PSW
    public void addItemByID(@PathVariable String id, @RequestBody Item item, @RequestBody String password){
        if (password.equals(shelterService.getPassword(id))) shelterService.addItem(id, item);
    }

    @DeleteMapping(path = "{id}/item/{iName}") //Shelter PSW
    public void removeItemByID(@PathVariable String id, @PathVariable String iName, @RequestBody String password){
        if (password.equals(shelterService.getPassword(id))) shelterService.removeItem(id, iName);
    }

    @PutMapping (path = "{id}/item/{iName}/add") //Shelter PSW
    public void addItemQuantityByOne(@PathVariable String id, @PathVariable String iName, @RequestBody String password){
        if (password.equals(shelterService.getPassword(id))) shelterService.addQuant(id, iName);
    }

    @PutMapping(path = "{id}/item/{iName}/sub") //Shelter PSW
    public void subItemQuantityByOne(@PathVariable String id, @PathVariable String iName, @RequestBody String password){
        if (password.equals(shelterService.getPassword(id))) shelterService.minQuant(id, iName);
    }

    @GetMapping(path = "{id}/item/{iName}/priority")
    public int getPriority(@PathVariable String id, @PathVariable String iName){
        return shelterService.getPrior(id, iName);
    }

    @PutMapping(path = "{id}/item/{iName}/priority") //Shelter PSW
    public void changePriority(@PathVariable String id, @PathVariable String iName, @RequestBody int priority, @RequestBody String password){
        if (password.equals(shelterService.getPassword(id))) shelterService.changePrior(id, iName, priority);
    }
}

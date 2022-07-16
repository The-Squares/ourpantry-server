package com.congapp.ShelterInv.api;

import java.util.List;
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

import com.congapp.ShelterInv.model.Item;
import com.congapp.ShelterInv.model.Shelter;
import com.congapp.ShelterInv.model.Item.Level;
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
    public Shelter getShelterByID(@PathVariable UUID id){
        return shelterService.getShelterById(id);
    }

    @DeleteMapping(path = "{id}") //Shelter PSW
    public int removeShelter(@PathVariable UUID id){
        return shelterService.removeShelter(id);
    }

    @GetMapping(path = "{id}/item") //Shelter PSW
    public List<Item> getItemsByID(@PathVariable UUID id, @RequestBody Item item){
        return shelterService.getItems(id);
    }

    @PostMapping(path = "{id}/item") //Shelter PSW
    public int addItemByID(@PathVariable UUID id, @RequestBody Item item){
        return shelterService.addItem(id, item);
    }

    @DeleteMapping(path = "{id}/item/{iName}") //Shelter PSW
    public int removeItemByID(@PathVariable UUID id, @PathVariable String iName){
        return shelterService.removeItem(id, iName);
    }

    @PutMapping (path = "{id}/item/{iName}/add") //Shelter PSW
    public int addItemQuantityByOne(@PathVariable UUID id, @PathVariable String iName){
        return shelterService.addQuant(id, iName);
    }

    @PutMapping(path = "{id}/item/{iName}/sub") //Shelter PSW
    public int subItemQuantityByOne(@PathVariable UUID id, @PathVariable String iName){
        return shelterService.minQuant(id, iName);
    }

    @GetMapping(path = "{id}/item/{iName}/priority")
    public Level getPriority(@PathVariable UUID id, @PathVariable String iName){
        return shelterService.getPrior(id, iName);
    }

    @PutMapping(path = "{id}/item/{iName}/priority") //Shelter PSW
    public int changePriority(@PathVariable UUID id, @PathVariable String iName, @RequestParam int priority){
        return shelterService.changePrior(id, iName, priority);
    }
}

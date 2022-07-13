package com.congapp.ShelterInv.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public Shelter getShelterByID(@PathVariable UUID id){
        return shelterService.getShelterById(id);
    }

    @DeleteMapping(path = "{id}")
    public int removeShelter(@PathVariable UUID id){
        return shelterService.removeShelter(id);
    }

    @PostMapping(path = "{id}/item")
    public int addItemById(@PathVariable UUID id, @RequestBody Item item){
        return shelterService.addItem(id, item);
    }

    @DeleteMapping(path = "{id}/item/{Iid}")
    public int removeItemById(@PathVariable UUID id, @PathVariable UUID Iid){
        return shelterService.removeItem(id, Iid);
    }


}

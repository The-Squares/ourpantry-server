package com.congapp.ShelterInv.api;

import java.util.List;

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
import org.springframework.web.client.RestTemplate;
import org.springframework.data.geo.Point;

import com.congapp.ShelterInv.model.BarItem;
import com.congapp.ShelterInv.model.Item;
import com.congapp.ShelterInv.model.ItemPlus;
import com.congapp.ShelterInv.model.Login;
import com.congapp.ShelterInv.model.Shelter;
import com.congapp.ShelterInv.service.ShelterService;

@RequestMapping("api/v1/shelter")
@RestController
public class ShelterController {

    private final ShelterService shelterService;

    private String apiKey = "d663ed7fc61c7862407b3238545d9723";

    @Autowired
    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @PostMapping
    public void addShelter(@RequestBody Shelter shelter) {
        shelterService.addShelter(shelter);
    }

    @GetMapping
    public List<Shelter> getAllShelters() {
        return shelterService.getAllShelters();
    }

    @GetMapping(path = "{id}")
    public Shelter getShelterByID(@PathVariable String id) {
        return shelterService.getShelterById(id);
    }

    @PostMapping(path = "login")
    public Shelter loginShelter(@RequestBody Login loginInfo) {
        return shelterService.loginShelter(loginInfo.getEmail(), loginInfo.getPassword());
    }

    @DeleteMapping(path = "{id}") // Shelter PSW
    public void removeShelter(@PathVariable String id, @RequestBody String password) {
        if (password.equals(shelterService.getPassword(id)))
            shelterService.removeShelter(id);
    }

    @GetMapping(path = "{id}/item") // Shelter PSW
    public List<Item> getItemsByID(@PathVariable String id, @RequestParam String password) {
        return shelterService.getItems(id);
    }

    @PostMapping(path = "{id}/item") // Shelter PSW
    public void addItemByID(@PathVariable String id, @RequestBody ItemPlus item) {
        if (item.getPassword().equals(shelterService.getPassword(id)))
            shelterService.addItem(id, item.getItem());
    }

    @DeleteMapping(path = "{id}/item/{iName}") // Shelter PSW
    public void removeItemByID(@PathVariable String id, @PathVariable String iName, @RequestBody String password) {
        if (password.equals(shelterService.getPassword(id)))
            shelterService.removeItem(id, iName);
    }

    @PutMapping(path = "{id}/item/{iName}/add") // Shelter PSW
    public void addItemQuantityByOne(@PathVariable String id, @PathVariable String iName,
            @RequestBody String password) {
        if (password.equals(shelterService.getPassword(id)))
            shelterService.addQuant(id, iName);
    }

    @PutMapping(path = "{id}/item/{iName}/sub") // Shelter PSW
    public void subItemQuantityByOne(@PathVariable String id, @PathVariable String iName,
            @RequestBody String password) {
        if (password.equals(shelterService.getPassword(id)))
            shelterService.minQuant(id, iName);
    }

    @GetMapping(path = "{id}/item/{iName}/priority")
    public int getPriority(@PathVariable String id, @PathVariable String iName) {
        return shelterService.getPrior(id, iName);
    }

    @PutMapping(path = "{id}/item/{iName}/priority") // Shelter PSW
    public void changePriority(@PathVariable String id, @PathVariable String iName, @RequestParam int priority,
            @RequestBody String password) {
        if (password.equals(shelterService.getPassword(id)))
            shelterService.changePrior(id, iName, priority);
    }

    @GetMapping("{id}/cords")
    public Point getCords(@PathVariable String id) {
        return shelterService.getCordsById(id);
    }

    @RequestMapping("barcode")
    public BarItem getItemByBarCode(@RequestParam String UPC) {
        RestTemplate restTemplate = new RestTemplate();

        if ((restTemplate.getForObject("https://www.brocade.io/api/items/" + UPC, BarItem.class)) != null) {
            return restTemplate.getForObject("https://www.brocade.io/api/items/" + UPC, BarItem.class);
        }

        return null;
    }

}

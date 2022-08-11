package com.congapp.ShelterInv.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.geo.Circle;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.congapp.ShelterInv.dao.ShelterDao;
import com.congapp.ShelterInv.model.Item;
import com.congapp.ShelterInv.model.Location;
import com.congapp.ShelterInv.model.PositionResponse;
import com.congapp.ShelterInv.model.Shelter;

@Service
public class ShelterService {

    private final ShelterDao shelterDao;
    // private final PasswordEncoder passwordEncoder;
    private final RestTemplate restTemplate = new RestTemplate();

    private String apiKey = "d663ed7fc61c7862407b3238545d9723";

    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    public ShelterService (@Qualifier("shelDao") ShelterDao shelterDao){
        this.shelterDao = shelterDao;
        // this.passwordEncoder = new BCryptPasswordEncoder();
    }
    
    public Shelter addShelter (Shelter shelter){
        // String password = passwordEncoder.encode(shelter.getPassword());
        // shelter.setPassword(password);

        PositionResponse posRes = restTemplate.getForObject("http://api.positionstack.com/v1/forward?access_key=" + apiKey + "&query=" + shelter.getAddress(), PositionResponse.class);
        
        Location cord = posRes.getData().get(0);
        Point cordinates = new Point(cord.getLongitude(), cord.getLatitude());

        shelter.setCords(cordinates);

        return shelterDao.insert(shelter);
    }

    public List<Shelter> getAllShelters(){
        return shelterDao.findAll();
    }

    public Shelter getShelterById(String id){
        if (shelterDao.findById(id).isPresent()){
            return shelterDao.findById(id).get();
        }
        return null;
    }

    public void removeShelter (String id){
        if (shelterDao.findById(id).isPresent()){
            shelterDao.deleteById(id);
        }
    }

    public List<Item> getItems(String id){
        if (shelterDao.findById(id).isPresent()){
            return shelterDao.findById(id).get().getOffers();
        }
        return Collections.emptyList();
    }

    public String getPassword (String id){
        if (shelterDao.findById(id).isPresent()){
            return shelterDao.findById(id).get().getPassword();
        }
        return null;
    }

    public String getAddress(String id){
        if (shelterDao.findById(id).isPresent()){
            return shelterDao.findById(id).get().getAddress();
        }
        return null;
    }

    public Point getCordsById(String id){
        if (shelterDao.findById(id).isPresent()){
        return shelterDao.findById(id).get().getCords();
        }
        return null;
    }

    public void addItem(String id, Item item){
        if (shelterDao.findById(id).isPresent()){
            Shelter shelter = shelterDao.findById(id).get();
            shelter.addItem(item);
            shelterDao.save(shelter);
        }
    }

    public void removeItem(String id, String iName){
        if (shelterDao.findById(id).isPresent()){
            Shelter shelter = shelterDao.findById(id).get();
            shelter.removeItemByName(iName);
            shelterDao.save(shelter);
        }
    }

    public void addQuant(String id, String iName){
        if (shelterDao.findById(id).isPresent()){
            Shelter shelter = shelterDao.findById(id).get();
            shelter.getItemByName(iName).addQuant();
            shelterDao.save(shelter);
        }
    }

    public void minQuant(String id, String iName){
        if (shelterDao.findById(id).isPresent()){
            Shelter shelter = shelterDao.findById(id).get();
            shelter.getItemByName(iName).minQuant();
            shelterDao.save(shelter);
        }
    }

    public int getPrior(String id, String iName){
        if (shelterDao.findById(id).isPresent()) return shelterDao.findById(id).get().getItemByName(iName).getPriority();
        return 0;
    }

    public void changePrior(String id, String iName, int priority){
        if (shelterDao.findById(id).isPresent()){
            Shelter shelter = shelterDao.findById(id).get();
            shelter.getItemByName(iName).setPriority(priority);
            shelterDao.save(shelter);
        }
    }

    public List<Shelter> findByDistance(float latitude, float longitude, int distance){

        Point baseCords = new Point (longitude, latitude);

        Distance radius = new Distance (distance, Metrics.MILES);

        Circle area = new Circle(baseCords, radius);

        Query query = new Query();
        query.addCriteria(Criteria.where("geoLocation").withinSphere(area));

        return mongoOperations.find(query, Shelter.class);
    }

}

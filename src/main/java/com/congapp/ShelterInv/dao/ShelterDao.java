package com.congapp.ShelterInv.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.congapp.ShelterInv.model.Shelter;

@Repository("shelDao")
public interface ShelterDao extends MongoRepository<Shelter, String> {
    public List<Shelter> findByDistance(float latitude, double longitude, int distance){
        Point baseCords = new Point (latitude, longitude);

        Distance radius = new Distance (distance, Metrics.MILES);

        Circle area = new Circle(baseCords, radius);

        Query query = new Query();
        query.addCriteria(Criteria.where("address.geoLocation").withinSphere(area));

        return MongoOperations.find(query, Shelter.class);
}

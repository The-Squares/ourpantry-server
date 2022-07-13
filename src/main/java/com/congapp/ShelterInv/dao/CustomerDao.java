package com.congapp.ShelterInv.dao;

import java.util.List;
import java.util.UUID;

import com.congapp.ShelterInv.model.Customer;

public interface CustomerDao {
    
    int insertPerson(UUID id, Customer person);

    default int insertPerson(Customer person){
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Customer> selectAllPeople();

    Customer selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonName(UUID id, String name);

    int addBalanceById(UUID id, double amount);

    int subBalanceById(UUID id, double amount);

    int buyItem(UUID id, UUID mID, UUID itemID);

}


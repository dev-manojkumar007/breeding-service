package com.ideathon.breedingservice.repo;

import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ideathon.breedingservice.model.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, Binary> {	

}

package com.ideathon.breedingservice.repo;

import com.ideathon.breedingservice.model.Client;
import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, Binary> {

}

package com.ideathon.breedingservice.repo;

import com.ideathon.breedingservice.model.Client;
import com.ideathon.breedingservice.model.Patient;
import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends MongoRepository<Patient, Binary> {

    @Query("{\"clients.clientKey\" : ?0}")
    List<Patient> getPatientsByClientId(Binary id);
}

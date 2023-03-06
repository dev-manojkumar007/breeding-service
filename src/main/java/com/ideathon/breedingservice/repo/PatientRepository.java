package com.ideathon.breedingservice.repo;

import com.ideathon.breedingservice.model.Client;
import com.ideathon.breedingservice.model.Patient;
import java.util.List;
import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, Binary> {

    @Query("{\"clients.clientKey\" : ?0}")
    List<Patient> getPatientsByClientId(Binary id);
}


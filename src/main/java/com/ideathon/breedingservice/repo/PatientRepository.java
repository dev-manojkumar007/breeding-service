package com.ideathon.breedingservice.repo;

import com.ideathon.breedingservice.model.Patient;
import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, Binary> {

}

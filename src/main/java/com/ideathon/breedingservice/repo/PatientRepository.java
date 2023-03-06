package com.ideathon.breedingservice.repo;

import java.util.List;

import org.bson.types.Binary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ideathon.breedingservice.model.Patient;

@Repository
public interface PatientRepository extends MongoRepository<Patient, Binary> {	
	
	//List<Patient> findById(Binary id);
	
}


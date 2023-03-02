package com.ideathon.breedingservice.repo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ideathon.breedingservice.dao.MongoDbConnection;
import com.ideathon.breedingservice.model.Patient;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;

@Repository
public class PatientRepository {

	@Autowired
	MongoDbConnection mongoDbConnection;
	
	public List<Patient> findAll(){
		
		return mongoDbConnection.getPatient();
	}
	
}

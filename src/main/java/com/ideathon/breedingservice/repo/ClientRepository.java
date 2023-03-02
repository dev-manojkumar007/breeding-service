package com.ideathon.breedingservice.repo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ideathon.breedingservice.dao.MongoDbConnection;
import com.ideathon.breedingservice.model.Client;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;

@Repository
public class ClientRepository {
	
	@Autowired
	MongoDbConnection mongoDbConnection;
	
	public List<Client> findAll(){
			return mongoDbConnection.getClient();
    }
}

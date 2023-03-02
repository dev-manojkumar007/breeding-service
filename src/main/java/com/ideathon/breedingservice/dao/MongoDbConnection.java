package com.ideathon.breedingservice.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ideathon.breedingservice.model.Patient;
import com.ideathon.breedingservice.model.Client;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;

import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
@Component
public class MongoDbConnection {

	@Value("${spring.data.mongodb.uri}")
	private String uri;
	
	@Value("${spring.data.mongodb.database}")
	private String db;
	
	public List<Patient> getPatient() {
		
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		
		try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase(db).withCodecRegistry(pojoCodecRegistry);
            Document query = new Document();

            List<Patient> listPatient = database.getCollection("Patient").find(query, Patient.class).into(new ArrayList());            

            return listPatient;
            } catch (MongoException me) {
                System.err.println("An error occurred while attempting to run a command: " + me);
            }
		return null;
	}	
	
	public List<Client> getClient() {
		try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase(db);
    		List<Client> listPatient = new ArrayList<>();
            
            FindIterable<Document> itrDocs = database.getCollection("client").find();            
            Iterator it = itrDocs.iterator();
            while(it.hasNext()) {
            	listPatient.add((Client)it.next());
            }
            
            return listPatient;
            } catch (MongoException me) {
                System.err.println("An error occurred while attempting to run a command: " + me);
            }
		return null;
	}	
}

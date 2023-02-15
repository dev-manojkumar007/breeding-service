package com.ideathon.breedingservice;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
public class MongoConnect {
    public static void main(String[] args) {
       String uri = "mongodb+srv://abhisheksingh:Abhi1234@cluster0.pglufpf.mongodb.net/test";

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("breedingService");
            MongoCollection<Document> collection = database.getCollection("pets");
            Document doc = collection.find(eq("animals", "Cat")).first();
            if (doc != null) {
                System.out.println("String read as "+doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }
}

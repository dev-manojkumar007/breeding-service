package com.ideathon.breedingservice.controller;

import com.ideathon.breedingservice.model.Client;
import com.ideathon.breedingservice.model.Patient;
import com.ideathon.breedingservice.repo.ClientRepository;
import com.ideathon.breedingservice.repo.PatientRepository;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/feature")
public class FeatureController {

    private ClientRepository clientRepository;
    private PatientRepository patientRepository;
    
    @Autowired
    private MongoTemplate mongoTemplate	;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    
 
    @GetMapping("/searchPatient")
    public List<Patient> searchPatient(@RequestParam("breedCode") String breedCode, @RequestParam("age") String age, @RequestParam("weight") String weight, @RequestParam("healthCondition") String healthCondition, @RequestParam("patientId") String patientId, @RequestParam("clientId") String clientId){
    	
       	Query query = new Query();
       	
       	query.addCriteria(Criteria.where("weight").is(weight));
       	query.addCriteria(Criteria.where("breedCode").is(breedCode));
       	query.addCriteria(Criteria.where("healthConditions").is(healthCondition));
      
        return mongoTemplate.find(query,Patient.class);
    }
}


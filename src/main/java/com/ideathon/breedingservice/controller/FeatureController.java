package com.ideathon.breedingservice.controller;

import com.ideathon.breedingservice.model.Client;
import com.ideathon.breedingservice.model.Patient;
import com.ideathon.breedingservice.repo.ClientRepository;
import com.ideathon.breedingservice.repo.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/feature")
public class FeatureController {

    private ClientRepository clientRepository;
    private PatientRepository patientRepository;

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

}


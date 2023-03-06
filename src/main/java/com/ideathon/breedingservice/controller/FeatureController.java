package com.ideathon.breedingservice.controller;

import com.ideathon.breedingservice.dto.ClientDataDto;
import com.ideathon.breedingservice.model.Client;
import com.ideathon.breedingservice.model.Patient;
import com.ideathon.breedingservice.repo.ClientRepository;
import com.ideathon.breedingservice.repo.PatientRepository;
import com.ideathon.breedingservice.service.CentralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/feature")
public class FeatureController {

    private ClientRepository clientRepository;
    private PatientRepository patientRepository;
    private CentralService centralService;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Autowired
    public void setPatientRepository(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Autowired
    public void setCentralService(CentralService centralService) {
        this.centralService = centralService;
    }

    @GetMapping("/client/email/{email}")
    public ClientDataDto getClientDataByEmail(@PathVariable String email) {
        return centralService.getClientData(email);
    }
}


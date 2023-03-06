package com.ideathon.breedingservice.service;

import com.ideathon.breedingservice.dto.ClientDataDto;
import com.ideathon.breedingservice.dto.PatientDataDto;
import com.ideathon.breedingservice.model.Client;
import com.ideathon.breedingservice.model.Patient;
import com.ideathon.breedingservice.repo.ClientRepository;
import com.ideathon.breedingservice.repo.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class CentralService {

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

    public ClientDataDto getClientData(String email) {
        List<Client> clientList = clientRepository.getClientByEmail(email);

        if(clientList.size() == 0) {
            log.info("No Client Exist with client email : " + email);
            return null;
        }

        Client targetClient = clientList.stream().findFirst().get();

        ClientDataDto clientDataDto = new ClientDataDto();

        clientDataDto.setClientId(targetClient.getId());
        clientDataDto.setFirstName(targetClient.getGivenName());
        clientDataDto.setLastName(targetClient.getFamilyName());

        List<Patient> pets = getPatientsByClientId(targetClient.getId());

        if(pets.size() == 0) {
            log.info("Client with email : " + email + " has no pets ");
            return clientDataDto;
        }

        List<PatientDataDto> patientDataDtoList = new ArrayList<>();
        for(Patient patient : pets) {
            PatientDataDto patientDataDto = new PatientDataDto();
            patientDataDto.setPatientId(patient.getId());
            patientDataDto.setName(patient.getName());
            patientDataDto.setSexCode(patient.getSexCode());
            patientDataDto.setSpecieCode(patient.getSpeciesCode());
            patientDataDto.setAge(getAgeFromDateOfBirth(patient.getDateOfBirth()));

            patientDataDtoList.add(patientDataDto);
        }

        clientDataDto.setPets(patientDataDtoList);

        return clientDataDto;
    }

    public List<Patient> getPatientsByClientId(Binary clientId) {
        return patientRepository.getPatientsByClientId(clientId);
    }

    private int getAgeFromDateOfBirth(Date dob) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthDate = dateFormat.format(dob);
        String currentDate = dateFormat.format(new Date());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date fromDate = null;
        Date toDate = null;
        long difference_In_Time = 0L;

        try {
            fromDate = sdf.parse(birthDate);
            toDate = sdf.parse(currentDate);
            difference_In_Time = toDate.getTime() - fromDate.getTime();
        } catch (Exception e) {
            log.error("Error while calculating age");
        }

        long difference_In_Years
                = (difference_In_Time
                / (1000l * 60 * 60 * 24 * 365));

        int age = (int) difference_In_Years;

        return age;
    }

}

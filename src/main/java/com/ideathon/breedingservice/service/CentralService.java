package com.ideathon.breedingservice.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.ideathon.breedingservice.dto.BreedingRequestDto;
import com.ideathon.breedingservice.model.PetBreedingRequest;
import com.ideathon.breedingservice.repo.BreedingRequestRepository;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.ideathon.breedingservice.dto.ClientDataDto;
import com.ideathon.breedingservice.dto.PatientDataDto;
import com.ideathon.breedingservice.model.Client;
import com.ideathon.breedingservice.model.Patient;
import com.ideathon.breedingservice.repo.ClientRepository;
import com.ideathon.breedingservice.repo.PatientRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CentralService {

    private ClientRepository clientRepository;
    private PatientRepository patientRepository;
    private BreedingRequestRepository breedingRequestRepository;
    
    
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

    @Autowired
    public void setBreedingRequestRepository(BreedingRequestRepository breedingRequestRepository) {
        this.breedingRequestRepository = breedingRequestRepository;
    }

    public ClientDataDto getClientData(String email) {
        List<Client> clientList = clientRepository.getClientByEmail(email);

        if(clientList.size() == 0) {
          //  Logger.info("No Client Exist with client email : " + email);
            return null;
        }

        Client targetClient = clientList.stream().findFirst().get();

        ClientDataDto clientDataDto = new ClientDataDto();

        clientDataDto.setClientId(targetClient.getId());
        clientDataDto.setFirstName(targetClient.getGivenName());
        clientDataDto.setLastName(targetClient.getFamilyName());
        if(targetClient.getAddresses().size() != 0) {
            clientDataDto.setAddress(targetClient.getAddresses().stream().findFirst().get());
        }

        List<Patient> pets = getPatientsByClientId(targetClient.getId());

        if(pets.size() == 0) {
           // log.info("Client with email : " + email + " has no pets ");
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
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); String birthDate
		 * = dateFormat.format(dob); String currentDate = dateFormat.format(new Date());
		 * 
		 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 * 
		 * Date fromDate = null; Date toDate = null; long difference_In_Time = 0L;
		 * 
		 * try { fromDate = sdf.parse(birthDate); toDate = sdf.parse(currentDate);
		 * difference_In_Time = toDate.getTime() - fromDate.getTime(); } catch
		 * (Exception e) { //log.error("Error while calculating age"); }
		 * 
		 * long difference_In_Years = (difference_In_Time / (1000l * 60 * 60 * 24 *
		 * 365));
		 * 
		 * int age = (int) difference_In_Years;
		 * 
		 */
    	LocalDate curDate = LocalDate.now();  
    	int age = Period.between(dob.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), curDate).getYears();
    	
    	
    	return age;
    }
    
    /**
     * This method will return Patient Data with required information.
     * @param breedCode
     * @param age
     * @param weight
     * @param healthCondition
     * @return
     */
    public List<PatientDataDto> getPatientData(String breedCode, String age, String weight, String healthCondition){
    	
    	Query query = new Query();
       	
       	String[] weightRange = weight.split("-");
       	
       	query.addCriteria(Criteria.where("weight").gte(weightRange[0]).lt(weightRange[1]));
       	query.addCriteria(Criteria.where("breedCode").is(breedCode));
       	query.addCriteria(Criteria.where("healthConditions").is(healthCondition));
       	
       	List<Patient> listPatient = mongoTemplate.find(query,Patient.class);
       	List<Patient> patientWithAgeCheck = getAge(listPatient, age);
       	
       	List<PatientDataDto> patientDataDtoList = new ArrayList<>();
        for(Patient patient : patientWithAgeCheck) {
            PatientDataDto patientDataDto = new PatientDataDto();
            patientDataDto.setPatientId(patient.getId());
            patientDataDto.setName(patient.getName());
            patientDataDto.setSexCode(patient.getSexCode());
            patientDataDto.setSpecieCode(patient.getSpeciesCode());
            patientDataDto.setAge(getAgeFromDateOfBirth(patient.getDateOfBirth()));
            patientDataDto.setAllergies(patient.getKnownAllergies());
            patientDataDto.setBreedCode(patient.getBreedCode());
            patientDataDto.setHealthCondition(patient.getHealthConditions());
            patientDataDto.setWeight(patient.getWeight());
            patientDataDtoList.add(patientDataDto);
        }
        
        return patientDataDtoList;
    }

    public boolean processBreedingRequest(BreedingRequestDto breedingRequestDto) {

        try {
            PetBreedingRequest petBreedingRequest = new PetBreedingRequest();

            petBreedingRequest.setSenderClientId(breedingRequestDto.getSenderClientId());
            petBreedingRequest.setSenderPatientId(breedingRequestDto.getSenderPatientId());
            petBreedingRequest.setReceiverClientId(breedingRequestDto.getReceiverClientId());
            petBreedingRequest.setReceiverPatientId(breedingRequestDto.getReceiverPatientId());

            breedingRequestRepository.save(petBreedingRequest);

        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    private List<Patient> getAge(List<Patient> listPatient, String age) {
		String[] ageArray = age.split("-");
		int startAge = Integer.parseInt(ageArray[0]);
		int endAge = Integer.parseInt(ageArray[1]);
		LocalDate localDate = LocalDate.now();
	
		return listPatient.stream().filter(p -> Period.between(p.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), localDate).getYears()>=startAge &&
				Period.between(p.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), localDate).getYears()<=endAge).collect(Collectors.toList());
		
	}
}

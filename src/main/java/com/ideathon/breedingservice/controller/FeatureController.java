package com.ideathon.breedingservice.controller;

import java.util.List;

import com.ideathon.breedingservice.dto.BreedingRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideathon.breedingservice.dto.ClientDataDto;
import com.ideathon.breedingservice.dto.PatientDataDto;
import com.ideathon.breedingservice.repo.ClientRepository;
import com.ideathon.breedingservice.repo.PatientRepository;
import com.ideathon.breedingservice.service.CentralService;

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

	@GetMapping("/searchPatient")
	public List<PatientDataDto> searchPatient(@RequestParam("breedCode") String breedCode,
			@RequestParam("age") String age, @RequestParam("weight") String weight,
			@RequestParam("healthCondition") String healthCondition, @RequestParam("patientId") String patientId,
			@RequestParam("clientId") String clientId) {

		return centralService.getPatientData(breedCode, age, weight, healthCondition);
	}

	@PostMapping("/client/requestBreeding")
	public Boolean sendBreedingRequestToClient(@RequestBody BreedingRequestDto breedingRequestDto) {
		return centralService.processBreedingRequest(breedingRequestDto);
	}

}

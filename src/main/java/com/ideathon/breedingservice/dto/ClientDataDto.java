package com.ideathon.breedingservice.dto;

import com.ideathon.breedingservice.model.Address;
import org.bson.types.Binary;

import java.util.List;

public class ClientDataDto {

    private Binary clientId;
    private String firstName;
    private String lastName;
    private Address address;
    List<PatientDataDto> pets;
    private double latitude;
    private double longitude;

    public Binary getClientId() {
        return clientId;
    }

    public void setClientId(Binary clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() { return address; }

    public void setAddress(Address address) { this.address = address; }

    public List<PatientDataDto> getPets() {
        return pets;
    }

    public void setPets(List<PatientDataDto> pets) {
        this.pets = pets;
    }

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
    
}

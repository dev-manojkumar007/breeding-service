package com.ideathon.breedingservice.dto;

import org.bson.types.Binary;

import java.util.List;

public class ClientDataDto {

    private Binary clientId;
    private String firstName;
    private String lastName;
    List<PatientDataDto> pets;

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

    public List<PatientDataDto> getPets() {
        return pets;
    }

    public void setPets(List<PatientDataDto> pets) {
        this.pets = pets;
    }
}

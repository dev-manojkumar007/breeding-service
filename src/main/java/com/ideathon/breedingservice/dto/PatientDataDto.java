package com.ideathon.breedingservice.dto;

import org.bson.types.Binary;

public class PatientDataDto {

    private Binary patientId;
    private String name;
    private String specieCode;
    private String sexCode;
    private int age;

    public Binary getPatientId() {
        return patientId;
    }

    public void setPatientId(Binary patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecieCode() {
        return specieCode;
    }

    public void setSpecieCode(String specieCode) {
        this.specieCode = specieCode;
    }

    public String getSexCode() {
        return sexCode;
    }

    public void setSexCode(String sexCode) {
        this.sexCode = sexCode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

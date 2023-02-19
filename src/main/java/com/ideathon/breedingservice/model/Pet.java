package com.ideathon.breedingservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("pet")
public class Pet {

    @Id
    private String id;

    private String name;

    private Date birthDate;

    private String sex;

    private String color;

    private Integer weightInPounds;

    private String breedId;

    private String specieId;

    private String clientId;

    public Pet(String id, String name, Date birthDate, String sex, String color, Integer weightInPounds, String breedId, String specieId, String clientId) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
        this.color = color;
        this.weightInPounds = weightInPounds;
        this.breedId = breedId;
        this.specieId = specieId;
        this.clientId = clientId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(Integer weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public String getBreedId() {
        return breedId;
    }

    public void setBreedId(String breedId) {
        this.breedId = breedId;
    }

    public String getSpecieId() {
        return specieId;
    }

    public void setSpecieId(String specieId) {
        this.specieId = specieId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}

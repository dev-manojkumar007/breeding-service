package com.ideathon.breedingservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "pet")
public class Pet {

    @Id
    private Long id;

    private String name;

    private Date birthDate;

    private String sex;

    private String color;

    private Integer weightInPounds;

    private Boolean isAllergic;

    private Long breedId;

    private Long specieId;

    private Long clientId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Boolean getAllergic() {
        return isAllergic;
    }

    public void setAllergic(Boolean allergic) {
        isAllergic = allergic;
    }

    public Long getBreedId() {
        return breedId;
    }

    public void setBreedId(Long breedId) {
        this.breedId = breedId;
    }

    public Long getSpecieId() {
        return specieId;
    }

    public void setSpecieId(Long specieId) {
        this.specieId = specieId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}

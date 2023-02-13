package com.ideathon.breedingservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collation = "pet")
public class Pet {

    @Id
    private Long id;

    private String name;

    private Date dob;

    private String sex;

    private String specie;

    private String breed;

    private String petType;

    private Boolean isAllergic;

    private Integer weightInPounds;


}

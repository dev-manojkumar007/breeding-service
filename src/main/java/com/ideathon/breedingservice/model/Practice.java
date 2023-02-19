package com.ideathon.breedingservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("practice")
public class Practice {

    private String id;

    private String name;

    private Long addressId;

    public Practice(String id, String name, Long addressId) {
        this.id = id;
        this.name = name;
        this.addressId = addressId;
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

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }
}

package com.ideathon.breedingservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "practice")
public class Practice {

    private Long id;

    private String name;

    private Long addressId;

    private List<Client> clients;

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

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}

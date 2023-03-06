package com.ideathon.breedingservice.model;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.Binary;

import java.util.Date;
import java.util.List;

public class EmailAddress {

    @BsonProperty("emailAddressKey") private Binary emailAddressKey;
    @BsonProperty("emailAddressTypeCodes") private List<String> emailAddressTypeCodes;
    @BsonProperty("address") private String address;
    @BsonProperty("isDeleted") private Boolean isDeleted;
    @BsonProperty("createdDate") private Date createdDate;
    @BsonProperty("modifiedDate") private Date modifiedDate;
    
    public EmailAddress() {
		// TODO Auto-generated constructor stub
	}

    public EmailAddress(Binary emailAddressKey, List<String> emailAddressTypeCodes, String address, Boolean isDeleted, Date createdDate, Date modifiedDate) {
        this.emailAddressKey = emailAddressKey;
        this.emailAddressTypeCodes = emailAddressTypeCodes;
        this.address = address;
        this.isDeleted = isDeleted;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Binary getEmailAddressKey() {
        return emailAddressKey;
    }

    public void setEmailAddressKey(Binary emailAddressKey) {
        this.emailAddressKey = emailAddressKey;
    }

    public List<String> getEmailAddressTypeCodes() {
        return emailAddressTypeCodes;
    }

    public void setEmailAddressTypeCodes(List<String> emailAddressTypeCodes) {
        this.emailAddressTypeCodes = emailAddressTypeCodes;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}

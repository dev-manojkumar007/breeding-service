package com.ideathon.breedingservice.model;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("client")
public class Client {

    @BsonProperty("_id") private Binary id;
    @BsonProperty("version") private Integer version;
    @BsonProperty("documentVersion") private String documentVersion;
    @BsonProperty("practiceKey") private Binary practiceKey;
    @BsonProperty("clientEmailPracticeKey") private String clientEmailPracticeKey;
    @BsonProperty("title") private String title;
    @BsonProperty("prefix") private String prefix;
    @BsonProperty("givenName") private String givenName;
    @BsonProperty("middleName") private String middleName;
    @BsonProperty("familyName") private String familyName;
    @BsonProperty("primaryEmailAddressKey") private Binary primaryEmailAddressKey;
    @BsonProperty("emailAddresses") private List<EmailAddress> emailAddresses;
    @BsonProperty("preferredContactMethodCode") private String preferredContactMethodCode;
    @BsonProperty("primaryPhoneKey") private Binary primaryPhoneKey;
    @BsonProperty("primaryAddressKey") private Binary primaryAddressKey;
    @BsonProperty("phoneNumbers") private List<PhoneNumber> phoneNumbers;
    @BsonProperty("addresses") private List<Address> addresses;
    @BsonProperty("isActive") private Boolean isActive;
    @BsonProperty("acceptsGenerics") private Boolean acceptsGenerics;
    @BsonProperty("dateOfBirth") private Date dateOfBirth;
    @BsonProperty("originTypeCode") private String originTypeCode;
    @BsonProperty("createdDate") private Date createdDate;
    @BsonProperty("modifiedDate") private Date modifiedDate;

    public Client() {
		// TODO Auto-generated constructor stub
	}
    public Client(Binary id, Integer version, String documentVersion, Binary practiceKey, String clientEmailPracticeKey, String title, String prefix, String givenName, String middleName, String familyName, Binary primaryEmailAddressKey, List<EmailAddress> emailAddresses, String preferredContactMethodCode, Binary primaryPhoneKey, Binary primaryAddressKey, List<PhoneNumber> phoneNumbers, List<Address> addresses, Boolean isActive, Boolean acceptsGenerics, Date dateOfBirth, String originTypeCode, Date createdDate, Date modifiedDate) {
        this.id = id;
        this.version = version;
        this.documentVersion = documentVersion;
        this.practiceKey = practiceKey;
        this.clientEmailPracticeKey = clientEmailPracticeKey;
        this.title = title;
        this.prefix = prefix;
        this.givenName = givenName;
        this.middleName = middleName;
        this.familyName = familyName;
        this.primaryEmailAddressKey = primaryEmailAddressKey;
        this.emailAddresses = emailAddresses;
        this.preferredContactMethodCode = preferredContactMethodCode;
        this.primaryPhoneKey = primaryPhoneKey;
        this.primaryAddressKey = primaryAddressKey;
        this.phoneNumbers = phoneNumbers;
        this.addresses = addresses;
        this.isActive = isActive;
        this.acceptsGenerics = acceptsGenerics;
        this.dateOfBirth = dateOfBirth;
        this.originTypeCode = originTypeCode;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Binary getId() {
        return id;
    }

    public void setId(Binary id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDocumentVersion() {
        return documentVersion;
    }

    public void setDocumentVersion(String documentVersion) {
        this.documentVersion = documentVersion;
    }

    public Binary getPracticeKey() {
        return practiceKey;
    }

    public void setPracticeKey(Binary practiceKey) {
        this.practiceKey = practiceKey;
    }

    public String getClientEmailPracticeKey() {
        return clientEmailPracticeKey;
    }

    public void setClientEmailPracticeKey(String clientEmailPracticeKey) {
        this.clientEmailPracticeKey = clientEmailPracticeKey;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Binary getPrimaryEmailAddressKey() {
        return primaryEmailAddressKey;
    }

    public void setPrimaryEmailAddressKey(Binary primaryEmailAddressKey) {
        this.primaryEmailAddressKey = primaryEmailAddressKey;
    }

    public List<EmailAddress> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(List<EmailAddress> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public String getPreferredContactMethodCode() {
        return preferredContactMethodCode;
    }

    public void setPreferredContactMethodCode(String preferredContactMethodCode) {
        this.preferredContactMethodCode = preferredContactMethodCode;
    }

    public Binary getPrimaryPhoneKey() {
        return primaryPhoneKey;
    }

    public void setPrimaryPhoneKey(Binary primaryPhoneKey) {
        this.primaryPhoneKey = primaryPhoneKey;
    }

    public Binary getPrimaryAddressKey() {
        return primaryAddressKey;
    }

    public void setPrimaryAddressKey(Binary primaryAddressKey) {
        this.primaryAddressKey = primaryAddressKey;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getAcceptsGenerics() {
        return acceptsGenerics;
    }

    public void setAcceptsGenerics(Boolean acceptsGenerics) {
        this.acceptsGenerics = acceptsGenerics;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getOriginTypeCode() {
        return originTypeCode;
    }

    public void setOriginTypeCode(String originTypeCode) {
        this.originTypeCode = originTypeCode;
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

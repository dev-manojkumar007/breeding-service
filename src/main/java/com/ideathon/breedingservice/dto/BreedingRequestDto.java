package com.ideathon.breedingservice.dto;

import org.bson.types.Binary;

public class BreedingRequestDto {

    private Binary senderClientId;
    private Binary senderPatientId;
    private Binary receiverClientId;
    private Binary receiverPatientId;

    public BreedingRequestDto() {
    }

    public BreedingRequestDto(Binary senderClientId, Binary senderPatientId, Binary receiverClientId, Binary receiverPatientId) {
        this.senderClientId = senderClientId;
        this.senderPatientId = senderPatientId;
        this.receiverClientId = receiverClientId;
        this.receiverPatientId = receiverPatientId;
    }

    public Binary getSenderClientId() {
        return senderClientId;
    }

    public void setSenderClientId(Binary senderClientId) {
        this.senderClientId = senderClientId;
    }

    public Binary getSenderPatientId() {
        return senderPatientId;
    }

    public void setSenderPatientId(Binary senderPatientId) {
        this.senderPatientId = senderPatientId;
    }

    public Binary getReceiverClientId() {
        return receiverClientId;
    }

    public void setReceiverClientId(Binary receiverClientId) {
        this.receiverClientId = receiverClientId;
    }

    public Binary getReceiverPatientId() {
        return receiverPatientId;
    }

    public void setReceiverPatientId(Binary receiverPatientId) {
        this.receiverPatientId = receiverPatientId;
    }
}

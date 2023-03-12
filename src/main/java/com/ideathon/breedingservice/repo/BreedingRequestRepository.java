package com.ideathon.breedingservice.repo;

import com.ideathon.breedingservice.model.PetBreedingRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BreedingRequestRepository extends MongoRepository<PetBreedingRequest, UUID> {
}

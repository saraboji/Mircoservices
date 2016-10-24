package com.emirates.availabilityhostservices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emirates.availabilityhostservices.domain.AvailabilityResponse;

public interface AvailabilityRepository extends MongoRepository<AvailabilityResponse, String> {

	public AvailabilityResponse findByFlightNumber(String flightNumber);
}

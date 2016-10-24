package com.emirates.bookinghostservices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.emirates.bookinghostservices.domain.BookingRequest;

public interface BookingRepository  extends MongoRepository<BookingRequest, String> {

	public BookingRequest findByFlightNumber(String flightNumber);
}

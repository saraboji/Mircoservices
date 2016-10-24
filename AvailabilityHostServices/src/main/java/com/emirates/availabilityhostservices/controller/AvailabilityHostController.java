package com.emirates.availabilityhostservices.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.availabilityhostservices.domain.AvailabilityResponse;
import com.emirates.availabilityhostservices.repository.AvailabilityRepository;

@RestController
public class AvailabilityHostController {

	
	@Autowired
	private AvailabilityRepository repository;
	
	@RequestMapping(value = "/getAVLFromHost",  method = GET)
	public AvailabilityResponse getAVLFromHost(@RequestParam(value="flightNumber") String flightNumber,
			@RequestParam(value="flightDate") String flightDate) {
		AvailabilityResponse availabilityResponseSample = new AvailabilityResponse();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy'T'HH:mm:ss");
		availabilityResponseSample.setFlightNumber("EK005");
		availabilityResponseSample.setFlightDate(dateFormat.format(new Date()));
		availabilityResponseSample.setOrigin("DXB");
		availabilityResponseSample.setDestination("LHR");
		availabilityResponseSample.setCurrency("AED");
		
		availabilityResponseSample.getAvailabilityCount().put("ECONOMY", 200);
		availabilityResponseSample.getAvailabilityCount().put("BUSINESS", 24);
		availabilityResponseSample.getAvailabilityCount().put("FIRST", 12);
		
		availabilityResponseSample.getFares().put("ECONOMY", 1500);
		availabilityResponseSample.getFares().put("BUSINESS", 3500);
		availabilityResponseSample.getFares().put("FIRST", 6000);
		
		this.repository.save(availabilityResponseSample);
		
		for (AvailabilityResponse availabilityResponse1 : this.repository.findAll()) {
			System.out.println("found availabilityResponse1 :"+availabilityResponse1.getFlightNumber());
		}
		return availabilityResponseSample;
	}
}

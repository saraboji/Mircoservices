package com.emirates.availabilityservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.availabilityhostservices.domain.AvailabilityResponse;
import com.emirates.availabilityservices.services.AvailabilityServicesClient;

@RestController
public class AvailabilityServicesController {

	@Autowired
	AvailabilityServicesClient client;
	
	@RequestMapping("/getAVL")
	public AvailabilityResponse getAVL(@RequestParam(value="flightNumber") String flightNumber,
			@RequestParam(value="flightDate") String flightDate) {
		return client.getAVLFromHost(flightNumber, flightDate);
	}
}

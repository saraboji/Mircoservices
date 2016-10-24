package com.emirates.availabilityservices.services;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emirates.availabilityhostservices.domain.AvailabilityResponse;

@FeignClient("AVAILABILITYHOSTSERVICES")
public interface AvailabilityServicesClientInterface {

	@RequestMapping(value = "/getAVLFromHost", method = GET)
	AvailabilityResponse getAVLFromHost(@RequestParam(value="flightNumber") String flightNumber,
			@RequestParam(value="flightDate") String flightDate);
}

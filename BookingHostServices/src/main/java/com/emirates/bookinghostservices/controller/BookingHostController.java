package com.emirates.bookinghostservices.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emirates.bookinghostservices.domain.BookingResponse;



public class BookingHostController {

	
	@RequestMapping(value = "/getAVLFromHost",  method = GET)
	public BookingResponse getAVLFromHost(@RequestParam(value="flightNumber") String flightNumber,
			@RequestParam(value="flightDate") String flightDate) {
		
	}
}

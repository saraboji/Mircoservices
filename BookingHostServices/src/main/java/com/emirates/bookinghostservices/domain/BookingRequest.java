package com.emirates.bookinghostservices.domain;

import org.springframework.data.annotation.Id;

public class BookingRequest {

	@Id
	private String id;
	
	private String flightNumber;
	private String flightDate;
	private String origin;
	private String destination;
	private Integer fare;
	private Integer pnr;
	private String cabinclass;
	private String currency;
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightDate() {
		return flightDate;
	}
	public void setFlightDate(String flightDate) {
		this.flightDate = flightDate;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Integer getFare() {
		return fare;
	}
	public void setFare(Integer fare) {
		this.fare = fare;
	}
	public Integer getPnr() {
		return pnr;
	}
	public void setPnr(Integer pnr) {
		this.pnr = pnr;
	}
	public String getCabinclass() {
		return cabinclass;
	}
	public void setCabinclass(String cabinclass) {
		this.cabinclass = cabinclass;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
}

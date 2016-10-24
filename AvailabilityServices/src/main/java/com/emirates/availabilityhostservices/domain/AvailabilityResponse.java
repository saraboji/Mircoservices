package com.emirates.availabilityhostservices.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import java.util.HashMap;
import java.util.Map;

public class AvailabilityResponse implements Serializable {

	
	@Id
	private String id;
	
	private String flightNumber;
	private String flightDate;
	private String origin;
	private String destination;
	private Map<String, Integer> availabilityCount;
	private Map<String, Integer> fares;
	private String currency;
	
	private boolean isFallBack;
	
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
	
	public Map<String, Integer> getAvailabilityCount() {
		if (availabilityCount == null) {
			availabilityCount = new HashMap<String, Integer>();
		}
		return availabilityCount;
	}
	public void setAvailabilityCount(Map<String, Integer> availabilityCount) {
		this.availabilityCount = availabilityCount;
	}
	public Map<String, Integer> getFares() {
		if (fares == null) {
			fares = new HashMap<String, Integer>();
		}
		return fares;
	}
	public void setFares(Map<String, Integer> fares) {
		this.fares = fares;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public boolean isFallBack() {
		return isFallBack;
	}
	public void setFallBack(boolean isFallBack) {
		this.isFallBack = isFallBack;
	}
	
	
	
	
}

package com.emirates.availabilityservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.emirates.availabilityhostservices.domain.AvailabilityResponse;
import com.emirates.availabilityservices.cache.CacheManagerCheck;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class AvailabilityServicesClient {
	
	
	
	
	@Autowired
	private ApplicationContext _applicationContext;
	
	
	
	@Autowired
	AvailabilityServicesClientInterface clientInterface;
	
	@CachePut(value = "availabilitycache", keyGenerator="keyGenerator")
	@HystrixCommand(fallbackMethod = "getAVLFromHostFromCache",
			groupKey = "getAVLFromHost", commandKey = "getAVLFromHost",
					commandProperties = {
					        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"),
					        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4"),
					        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
					        @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000") }, threadPoolProperties = {
					        @HystrixProperty(name = "coreSize", value = "20"),
					        @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000") }
			)
	public AvailabilityResponse getAVLFromHost(String flightNumber, String flightDate) {
		return clientInterface.getAVLFromHost(flightNumber, flightDate);
	}
	
	/*@HystrixCommand(fallbackMethod = "getAVLFallback",
			groupKey = "getAVL", commandKey = "getAVLFromHostFromCache",
			threadPoolKey = "getAVLFromHostFromCacheTPool")
	*/
	public AvailabilityResponse getAVLFromHostFromCache(String flightNumber, String flightDate) {
		AvailabilityResponse availabilityResponse = new AvailabilityResponse();
		try {
			if (CacheManagerCheck.cacheManager != null && CacheManagerCheck.cacheManager.getCache("availabilitycache") != null) { 
				Cache cache = CacheManagerCheck.cacheManager.getCache("availabilitycache");
				SimpleValueWrapper simpleValueWrapper = (SimpleValueWrapper) cache.get(flightNumber+","+flightDate);
				if (simpleValueWrapper != null) {
					Object out = simpleValueWrapper.get();
					if (out instanceof AvailabilityResponse) {
						availabilityResponse = (AvailabilityResponse) out;
					}
					if (availabilityResponse != null) {
						System.out.println("availabilityResponse2 : "+availabilityResponse.toString());
						availabilityResponse.setFallBack(true);
					}
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return availabilityResponse;
    }
	/*private String getAVLCacheKey(String flightNumber, String flightDate) {
		String cacheKey = null;
		if (flightNumber != null && flightDate != null) {
			cacheKey = flightNumber+"~"+flightDate;
		}
		return cacheKey;
	}*/
	
	/*AvailabilityResponse getAVLFallback() {
		return "None available! Your backup response form cache";
	}*/
}

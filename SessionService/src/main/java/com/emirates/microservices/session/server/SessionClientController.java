package com.emirates.microservices.session.server;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@RestController
public class SessionClientController {
	
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
	@Autowired
    private FeignSessionClient feignSessionClient;
	
	@RequestMapping(path="/fetchSessionByUserId/{userId}",method=RequestMethod.GET , produces="application/json")
	public ResponseEntity<SessionEntrySerializer> fetchSessionByUserId(@PathVariable("userId") String userId) throws RestClientException, URISyntaxException{
		 return feignSessionClient.getSessionByUserId(userId);
		 
	
	}
	
	@RequestMapping(path="/fetchSessionByToken/{token}",method=RequestMethod.GET , produces="application/json")
	public ResponseEntity<SessionEntrySerializer> fetchSessionByToken(@PathVariable("token") String token) throws RestClientException, URISyntaxException{
		return feignSessionClient.getSessionByToken(token);
	
	}
	
	@RequestMapping(path="/initSession",method=RequestMethod.POST , consumes="application/json", produces="application/json")
	public ResponseEntity<SessionEntrySerializer> initSession(@RequestBody SessionEntrySerializer serializer){
		return feignSessionClient.initialiseSession(serializer);
		
	}

	@RequestMapping(path="/removeSession",method=RequestMethod.POST , consumes="application/json", produces="application/json")
	public ResponseEntity removeSession(@RequestBody SessionEntrySerializer serializer){
		return feignSessionClient.clearSession(serializer);
		
	}
}

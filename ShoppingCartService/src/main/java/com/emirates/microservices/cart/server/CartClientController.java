package com.emirates.microservices.cart.server;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.HttpStatus;
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
public class CartClientController {
	
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
	@RequestMapping(path="/getCartEntries/{userId}",method=RequestMethod.GET , produces="application/json")
	public ResponseEntity<CartEntriesSerializer> getCartEntries(@PathVariable("userId") String userId) throws RestClientException, URISyntaxException{
			final ResponseEntity<CartEntriesSerializer> responseEntity = 
					restTemplate.getForEntity(new URI("http://CART-SERVICE/cartEntries/"+userId), CartEntriesSerializer.class);
			
		
			return responseEntity;
	
	}
	
	@RequestMapping(path="/putCartEntries",method=RequestMethod.POST , consumes="application/json", produces="application/json")
	public void putCartEntries(@RequestBody CartEntriesSerializer cartEntries){
		try {
			
			final RequestEntity<CartEntriesSerializer> entity = RequestEntity.post(new URI("http://CART-SERVICE/addCartEntries"))
					.contentType(MediaType.APPLICATION_JSON).body(cartEntries);
			restTemplate.exchange(entity, CartEntriesSerializer.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

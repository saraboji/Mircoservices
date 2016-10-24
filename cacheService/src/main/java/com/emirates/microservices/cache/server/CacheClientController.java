package com.emirates.microservices.cache.server;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


public class CacheClientController {
	
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
	@RequestMapping(path="/getCacheEntries/{entryKey}",method=RequestMethod.GET , produces="application/json")
	public String getCachedEntries(@PathVariable("entryKey") String entryKey){
		try {
			return restTemplate.getForObject(new URI("http://CACHE-SERVICE/cacheEntries/"+entryKey), String.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(path="/putCacheEntries",method=RequestMethod.POST , produces="application/json")
	public void putCacheEntries(@RequestParam("entryKey") String entryKey, @RequestParam("entryValue") String entryValue){
		try {
			final CacheEntry cacheEntry = new CacheEntry();
			cacheEntry.setEntryKey(entryKey);
			cacheEntry.setEntryKey(entryValue);
			final RequestEntity<CacheEntry> entity = RequestEntity.post(new URI("http://CACHE-SERVICE/addCacheEntries"))
					.contentType(MediaType.APPLICATION_JSON).body(cacheEntry);
			restTemplate.exchange(entity, String.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

package com.emirates.microservices.cache.server;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

@RestController
public class CacheController {

	private Cache cache;
	
	public CacheController() {
		final CacheManager cm = CacheManager.newInstance();
		cache = cm.getCache("sampleCache");
	}
	protected Logger logger = Logger.getLogger(CacheController.class
			.getName());

	@RequestMapping(path="/cacheEntries/{entryKey}",method=RequestMethod.GET, produces="application/json" )
	public ResponseEntity<CacheEntry> getCacheEntries(@PathVariable("entryKey") String entryKey) {
		String returnValue = "";
		System.out.println("CacheController.getCacheEntries()");
		final Element cachedValue = cache.get(entryKey);
		if(cachedValue != null){
			returnValue = cachedValue.toString();
		}
		final CacheEntry cacheEntry = new CacheEntry();
		cacheEntry.setEntryKey(entryKey);
		cacheEntry.setEntryValue(returnValue);
		ResponseEntity<CacheEntry> responseEntity = new ResponseEntity<CacheEntry>(cacheEntry, HttpStatus.OK);
		
		return responseEntity;
	}
	
	@RequestMapping(path="/addCacheEntries",method=RequestMethod.POST, produces="application/json" )
	public void addCacheEntries(@RequestParam("entryKey") String entryKey, @RequestParam("entryValue") String entryValue) {
		System.out.println("CacheController.addCacheEntries()");
		cache.put(new Element(entryKey, entryValue));
		
	}

}

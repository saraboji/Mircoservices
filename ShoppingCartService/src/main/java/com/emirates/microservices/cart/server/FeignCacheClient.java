//package com.emirates.microservices.cart.server;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@FeignClient("http://cache-service")
//public interface FeignCacheClient {
//
//	@RequestMapping(value="/cacheEntries/{entryKey}",method=RequestMethod.GET , produces="application/json")
//	public String getCachedEntries(@PathVariable("entryKey") String entryKey);
//	
//	@RequestMapping(path="/addCacheEntries",method=RequestMethod.POST , produces="application/json", consumes="application/json")
//	public void putCacheEntries(@RequestParam("entryKey") String entryKey, @RequestParam("entryValue") String entryValue);
//	
//}

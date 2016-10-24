package com.emirates.microservices.session.server;
//package com.emirates.microservices.cart.server;
//
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("http://session-service")
public interface FeignSessionClient {

	@RequestMapping(value="/session/{userId}",method=RequestMethod.GET , produces="application/json")
	public ResponseEntity<SessionEntrySerializer> getSessionByUserId(@PathVariable("userId") String userId);
	
	@RequestMapping(value="/sessionToken/{token}",method=RequestMethod.GET , produces="application/json")
	public ResponseEntity<SessionEntrySerializer> getSessionByToken(@PathVariable("token") String token);
	
	@RequestMapping(value="/createSession",method=RequestMethod.POST , produces="application/json")
	public ResponseEntity<SessionEntrySerializer> initialiseSession(@RequestBody SessionEntrySerializer serializer);
	
	@RequestMapping(path="/deleteSession",method=RequestMethod.POST, produces="application/json" )
	public ResponseEntity clearSession(@RequestBody SessionEntrySerializer serializer);
}

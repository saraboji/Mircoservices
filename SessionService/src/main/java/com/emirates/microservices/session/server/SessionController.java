package com.emirates.microservices.session.server;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

	@Autowired
	private SessionService sessionService;
	
	protected Logger logger = Logger.getLogger(SessionController.class
			.getName());

	@RequestMapping(path="/session/{userId}",method=RequestMethod.GET, produces="application/json" )
	public ResponseEntity<SessionEntrySerializer> getSessionByUserId(@PathVariable("userId") String userId) {
		
		logger.info("SessionController.getSessionByUserId()");
		SessionDTO sessionDTO = sessionService.retrieveSessionByUserId(userId);
		
		final SessionEntrySerializer sessionEntrySerializer = new SessionEntrySerializer();
		sessionEntrySerializer.setSessionEntry(sessionDTO);
		
		ResponseEntity<SessionEntrySerializer> responseEntity = 
				new ResponseEntity<SessionEntrySerializer>(sessionEntrySerializer, HttpStatus.OK);
		
		return responseEntity;
	}
	
	@RequestMapping(path="/sessionToken/{token}",method=RequestMethod.GET, produces="application/json" )
	public ResponseEntity<SessionEntrySerializer> getSessionByToken(@PathVariable("token") String token) {
		
		logger.info("SessionController.getSessionByToken()");
		SessionDTO sessionDTO = sessionService.retrieveSessionByToken(token);
		
		final SessionEntrySerializer sessionEntrySerializer = new SessionEntrySerializer();
		sessionEntrySerializer.setSessionEntry(sessionDTO);
		
		ResponseEntity<SessionEntrySerializer> responseEntity = 
				new ResponseEntity<SessionEntrySerializer>(sessionEntrySerializer, HttpStatus.OK);
		
		return responseEntity;
	}
	
	@RequestMapping(path="/createSession",method=RequestMethod.POST, produces="application/json" )
	public ResponseEntity<SessionEntrySerializer> createSession(@RequestBody SessionEntrySerializer serializer) throws UnsupportedEncodingException {
		logger.info("SessionController.createSession()");
		if(serializer != null){
			SessionDTO sessionDTO = serializer.getSessionEntry();
			final String userId = sessionDTO.getUserid();
			if(userId != null && userId.trim().length() > 0){
				 final String token =  Base64.getEncoder().encodeToString(userId.getBytes("UTF-8"));
			    
			     sessionDTO.setSessionToken(token);
			     sessionDTO = sessionService.createSession(sessionDTO);
			     final SessionEntrySerializer sessionEntrySerializer = new SessionEntrySerializer();
			     sessionEntrySerializer.setSessionEntry(sessionDTO);
			     return new ResponseEntity<SessionEntrySerializer>(sessionEntrySerializer, HttpStatus.OK);
			}
		}
		
		return new ResponseEntity(HttpStatus.BAD_REQUEST); 
		
	}

	@RequestMapping(path="/deleteSession",method=RequestMethod.POST, produces="application/json" )
	public ResponseEntity deleteSession(@RequestBody SessionEntrySerializer serializer) {
		logger.info("SessionController.deleteSession()");
		if(serializer != null){
			SessionDTO sessionDTO = serializer.getSessionEntry();
			sessionService.deleteSession(sessionDTO);
			return new ResponseEntity(HttpStatus.OK); 
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST); 
		
		
	}
}

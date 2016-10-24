package com.emirates.microservices.session.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

	@Autowired
	private SessionRepository sessionRepository;
	
	public SessionDTO createSession(final SessionDTO sessionDTO){
		final SessionEntity entity = new SessionEntity();
		BeanUtils.copyProperties(sessionDTO, entity);
		
		
		SessionEntity sessionEntity = sessionRepository.save(entity);
		final SessionDTO dto = new SessionDTO();
		if(sessionEntity != null){
			BeanUtils.copyProperties(sessionEntity,dto);
		}
			
		return dto;
		
	}
	
	public SessionDTO retrieveSessionByUserId(final String userId){
		SessionEntity sessionEntity = sessionRepository.findAllByUserid(userId);
		final SessionDTO dto = new SessionDTO();
		if(sessionEntity != null){
			BeanUtils.copyProperties(sessionEntity,dto);
		}
		
		
		return dto;
		
	}
	
	public SessionDTO retrieveSessionByToken(final String sessionToken){
		SessionEntity sessionEntity = sessionRepository.findAllBySessionToken(sessionToken);
		final SessionDTO dto = new SessionDTO();
		if(sessionEntity != null){
			BeanUtils.copyProperties(sessionEntity,dto);
		}
		
		return dto;
		
	}
	
	public void deleteSession(final SessionDTO sessionDTO){
		final SessionEntity entity = new SessionEntity();
		BeanUtils.copyProperties(sessionDTO,entity);
		sessionRepository.delete(entity);
		
	}
	
	
}

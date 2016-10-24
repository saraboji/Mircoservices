package com.emirates.microservices.session.server;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface SessionRepository extends JpaRepository<SessionEntity, Long>{

	public SessionEntity findAllByUserid(final String userid);
	
	public SessionEntity findAllBySessionToken(final String sessionToken);
	
}

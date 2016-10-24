package com.emirates.microservices.session.server;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SessionEntity {

	protected SessionEntity() {
		// TODO Auto-generated constructor stub
	}

	public SessionEntity(String userId, String sessionToken){
		this.userid = userId;
		this.sessionToken = sessionToken;
	
	}
	
	@Id
	@GeneratedValue
	private int entryId;
	
	@Column(nullable = false)
	private String userid;
	
	@Column(nullable = false)
	private String sessionToken;

	public int getEntryId() {
		return entryId;
	}

	public void setEntryId(int entryId) {
		this.entryId = entryId;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}
	
}

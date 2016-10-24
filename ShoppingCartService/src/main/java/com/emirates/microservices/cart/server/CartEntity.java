package com.emirates.microservices.cart.server;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CartEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5921038719283080441L;

	protected CartEntity() {
		// TODO Auto-generated constructor stub
	}

	public CartEntity(String userId, String item, float itemValue){
		this.userid = userId;
		this.item = item;
		this.itemValue = itemValue;
		this.isCheckedOut = false;
	}
	
	@Id
	@GeneratedValue
	private int entryId;
	
	@Column(nullable = false)
	private String userid;
	
	@Column(nullable = false)
	private String item;
	
	@Column(nullable = false)
	private float itemValue;
	
	@Column(nullable = false)
	private boolean isCheckedOut;

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

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public float getItemValue() {
		return itemValue;
	}

	public void setItemValue(float itemValue) {
		this.itemValue = itemValue;
	}

	public boolean isCheckedOut() {
		return isCheckedOut;
	}

	public void setCheckedOut(boolean isCheckedOut) {
		this.isCheckedOut = isCheckedOut;
	}

}

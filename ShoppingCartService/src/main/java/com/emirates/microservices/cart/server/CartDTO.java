package com.emirates.microservices.cart.server;

public class CartDTO {

	private int entryId;
	
	private String userid;
	
	private String item;
	
	private float itemValue;
	
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

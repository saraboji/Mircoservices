package com.emirates.bookinghostservices.domain;

public class BookingResponse {

	
	private String pnr;
	private String status;
	private boolean fallback;
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isFallback() {
		return fallback;
	}
	public void setFallback(boolean fallback) {
		this.fallback = fallback;
	}
	
	
	
}

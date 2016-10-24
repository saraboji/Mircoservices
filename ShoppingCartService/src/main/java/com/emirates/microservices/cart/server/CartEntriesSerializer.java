package com.emirates.microservices.cart.server;

import java.util.List;

public class CartEntriesSerializer {

	private List<CartDTO> cartEntries;

	public List<CartDTO> getCartEntries() {
		return cartEntries;
	}

	public void setCartEntries(List<CartDTO> cartEntries) {
		this.cartEntries = cartEntries;
	}
	
	
}

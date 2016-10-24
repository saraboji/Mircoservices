package com.emirates.microservices.cart.server;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;
	
	protected Logger logger = Logger.getLogger(CartController.class
			.getName());

	@RequestMapping(path="/cartEntries/{userId}",method=RequestMethod.GET, produces="application/json" )
	public ResponseEntity<CartEntriesSerializer> getCartEntries(@PathVariable("userId") String userId) {
		
		logger.info("CartController.getCartEntries()");
		List<CartDTO> list = cartService.retrieveCartItems(userId);
		if(list == null){
			list = new ArrayList<CartDTO>();
		}
		final CartEntriesSerializer cartEntriesSerializer = new CartEntriesSerializer();
		cartEntriesSerializer.setCartEntries(list);
		
		ResponseEntity<CartEntriesSerializer> responseEntity = new ResponseEntity<CartEntriesSerializer>(cartEntriesSerializer, HttpStatus.OK);
		
		return responseEntity;
	}
	
	@RequestMapping(path="/addCartEntries",method=RequestMethod.POST, produces="application/json" )
	public ResponseEntity<CartEntriesSerializer> addCartEntries(@RequestBody CartEntriesSerializer cartItems) {
		logger.info("CartController.addCartEntries()");
		final List<CartDTO> itemsAdded = cartService.addOrUpdateItemsToCart(cartItems.getCartEntries());
		final CartEntriesSerializer cartEntriesSerializer = new CartEntriesSerializer();
		cartEntriesSerializer.setCartEntries(itemsAdded);
		return new ResponseEntity<CartEntriesSerializer>(cartEntriesSerializer, HttpStatus.OK);
		
	}

	@RequestMapping(path="/updateCartEntries",method=RequestMethod.POST, produces="application/json" )
	public ResponseEntity<CartEntriesSerializer> updateCartEntries(@RequestParam("cartItems") CartEntriesSerializer cartItems) {
		logger.info("CartController.updateCartEntries()");
		List<CartDTO> updatedItems = cartService.addOrUpdateItemsToCart(cartItems.getCartEntries());
		final CartEntriesSerializer cartEntriesSerializer = new CartEntriesSerializer();
		cartEntriesSerializer.setCartEntries(updatedItems);
	
		return new ResponseEntity<CartEntriesSerializer>(cartEntriesSerializer, HttpStatus.OK);
		
	}
}

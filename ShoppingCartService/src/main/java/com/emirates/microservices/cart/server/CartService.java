package com.emirates.microservices.cart.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	public List<CartDTO> addOrUpdateItemsToCart(final List<CartDTO> cartDTO){
		final List<CartEntity> cartEntity = new ArrayList<CartEntity>();
		for(CartDTO dto:cartDTO){
			final CartEntity entity = new CartEntity();
			BeanUtils.copyProperties(dto, entity);
			cartEntity.add(entity);
		}
		
		List<CartEntity> cartEntities = cartRepository.save(cartEntity);
		final List<CartDTO> items = new ArrayList<CartDTO>();
		for(CartEntity entity:cartEntities){
			final CartDTO dto = new CartDTO();
			BeanUtils.copyProperties(entity,dto);
			items.add(dto);
		}
		
		
		return items;
		
	}
	
	public List<CartDTO> retrieveCartItems(final String userId){
		List<CartEntity> cartEntities = cartRepository.findAllByUserid(userId);
		final List<CartDTO> items = new ArrayList<CartDTO>();
		for(CartEntity entity:cartEntities){
			final CartDTO dto = new CartDTO();
			BeanUtils.copyProperties(entity,dto);
			items.add(dto);
		}
		return items;
		
	}
	
	public boolean deleteFromCart(final CartDTO cartDTO){
		return false;
		
	}
	
	
}

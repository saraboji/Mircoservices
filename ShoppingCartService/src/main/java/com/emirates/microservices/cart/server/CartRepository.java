package com.emirates.microservices.cart.server;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CartRepository extends JpaRepository<CartEntity, Long>{

	public List<CartEntity> findAllByUserid(final String userid);
	
}

package com.emirates.microservices.cart.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan
@EnableFeignClients
public class CartServer {

    public static void main(String[] args) {
        // Will configure using accounts-server.yml
        System.setProperty("spring.config.name", "cart-server");

        SpringApplication.run(CartServer.class, args);
    }
    
    @Bean
    @LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	} 
    
}

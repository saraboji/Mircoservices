package com.emirates.microservices.session.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.DiscoveryClient;

@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan
@EnableFeignClients
public class SessionServer {

	
    public static void main(String[] args) {
        // Will configure using accounts-server.yml
        System.setProperty("spring.config.name", "session-server");

        SpringApplication.run(SessionServer.class, args);
    }
    
    @Bean
    @LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	} 
    
}

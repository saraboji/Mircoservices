package com.emirates.availabilityservices;


import java.io.IOException;

import org.infinispan.manager.DefaultCacheManager;
import org.infinispan.spring.provider.SpringEmbeddedCacheManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.availabilityservices.cache.AVLCacheKeyGenerator;

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableCaching
@Configuration
public class AvailabilityServicesApplication {
	public static void main(String[] args) {
		SpringApplication.run(AvailabilityServicesApplication.class, args);
	}
	
	
	@Bean
    public KeyGenerator keyGenerator() {
        // configure and return an implementation of Spring's KeyGenerator SPI
        return new AVLCacheKeyGenerator();
    }
	
	@Bean
	public CacheManager cacheManager() {

		/*SpringEmbeddedCacheManager cm =  new SpringEmbeddedCacheManager(
				new DefaultCacheManager(
					new ConfigurationBuilder()
						.eviction()
							.maxEntries(20000)
							.strategy(EvictionStrategy.LIRS)
						.expiration()
							.wakeUpInterval(5000L)
							.maxIdle(120000L)
			           .build()
					)
				);
		 
		
		Configuration config = new ConfigurationBuilder()
				.eviction()
				.maxEntries(20000)
				.strategy(EvictionStrategy.LIRS)
			.expiration()
				.wakeUpInterval(5000L)
				.maxIdle(120000L)
           .build();*/
		
		SpringEmbeddedCacheManager cm = null;
		try {
			cm = new SpringEmbeddedCacheManager(
					new DefaultCacheManager("infinispan.xml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return cm;
	}
}


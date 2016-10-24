package com.emirates.bookinghostservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookingHostServiceApplication {

	public static void main(String[] args) {
        SpringApplication.run(BookingHostServiceApplication.class, args);
    }
}

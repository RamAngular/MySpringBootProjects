package com.eureka.server.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HelloEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloEurekaServerApplication.class, args);
	}
}

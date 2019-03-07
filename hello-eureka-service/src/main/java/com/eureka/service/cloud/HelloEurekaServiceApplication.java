package com.eureka.service.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableEurekaServer
@EnableAdminServer
//@ComponentScan("com.eureka.service.cloud")
public class HelloEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloEurekaServiceApplication.class, args);
	}
}


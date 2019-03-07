package com.eureka.client.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/hello/client")
public class HelloClientContoller {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/message")
	public String hello(){
		String url = "http://localhost:8072/rest/hello/server";
		return restTemplate.getForObject(url, String.class);
	}
}


@Configuration
 class Config{
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
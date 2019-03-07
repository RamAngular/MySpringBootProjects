package com.eureka.server.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/hello/server")
public class HelloServerContoller {

	@GetMapping("/message")
	public String getMessage(){
		return "hello world";
	}
}

package com.rmf.hellowold.controller;


import io.swagger.annotations.Api;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author RAMIREDDY
 *
 */
@RestController
@RequestMapping("/service")
@Api(value = "Hello World Spring Boot Rest API")
public class HelloWorldRestService {


	@GetMapping("/welcome")
	@Produces(MediaType.APPLICATION_JSON)
	public  String getMsg(){
		return "Welcome to spring-boot with rest api";
	}

	@GetMapping("/user/{login_id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getMsg(@PathVariable("login_id") String login_id){
		String name = "";
		if(login_id.trim().equals("1256"))
			name = "rami reddy";
		else if(login_id.trim().equals("1271"))
			name = "suneel reddy";
		else if(login_id.trim().equals("1276"))
			name = "bhasker reddy";

		return name;

	}
}

package com.vz.spring.batch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 
 * @author RAMIREDDY
 * @since 2018-JUNE-11
 */
@SpringBootApplication
//@ComponentScan(basePackages = "com.vz.spring.batch")
@EnableBatchProcessing
@EnableAutoConfiguration
@EnableSwagger2
public class SpringBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchApplication.class, args);
	}
}

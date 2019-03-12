
package com.vz.spring.batch.config.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * @author RAMIREDDY
 * @since 2018-June-13
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	Contact contact = new Contact("Rami Reddy", "https://springframework.guru/about/", "ramireddyvakamalla@gmail.com");
	ApiInfo apiInfo = new ApiInfo("Spring Boot Rest Api", "Spring Boot Batch Job", "1.0", "", contact, "Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0");
	
	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2)
		.groupName("public api")
		.apiInfo(apiInfo)
		.select()
		//.apis(RequestHandlerSelectors.basePackage("com.vz.spring"))
		.build();
	}

}

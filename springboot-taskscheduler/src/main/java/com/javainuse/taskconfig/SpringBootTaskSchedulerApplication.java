package com.javainuse.taskconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author RAMIREDDY
 * @since 2018-JULY-21
 */
/**
 * @EnableScheduling is a Spring Context module annotation.
 *  It internally imports the SchedulingConfiguration via the @Import(SchedulingConfiguration.class) instruction
 */
@SpringBootApplication//is a convenience annotation that adds all of the following @Configuration, @EnableAutoConfiguration and  @ComponentScan
@EnableScheduling //@EnableScheduling ensures that a background task executor will be created. Without it, nothing gets scheduled.
public class SpringBootTaskSchedulerApplication {
	//main method use the Spring Boots
	public static void main(String[] args) {
		SpringApplication.run(	new Object[] { SpringBootTaskSchedulerApplication.class }, args);//method to launch an spring boot application
	}
}
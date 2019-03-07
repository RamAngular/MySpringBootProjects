package com.eureka.client.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HelloEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloEurekaClientApplication.class, args);
	}
}

/*@RestController
class ServiceInstanceRestController {

	//@LoadBalanced
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
}
 */
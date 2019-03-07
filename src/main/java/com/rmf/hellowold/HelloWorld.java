/**
 * 
 */
package com.rmf.hellowold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * @author RAMIREDDY
 * @since 2017-NOV-25 Chennai
 */
@SpringBootApplication
@EnableSwagger2
public class HelloWorld {


	public HelloWorld(){
		//System.out.println(service.getMsg("Hello Spring boot Application"));
	}


	/*@Test
	public void run(){
		System.out.println(helloWorldService.getMsg("Hello Spring boot Application"));
	}*/
	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		ApplicationContext ctx = null;

		System.out.println(ctx = SpringApplication.run(HelloWorld.class, args));

//		System.out.println(ctx.getBeanDefinitionCount());
//
//		for(String bean: ctx.getBeanDefinitionNames()){
//			System.out.println(bean);
//		}
	}
	
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
		"classpath:/META-INF/resources/", "classpath:/resources/",
		"classpath:/static/dist/", "classpath:/public/","classpath:/public/dist/" };


	@Configuration
	@EnableWebMvc
	@ComponentScan
	/**
	 * 
	 * @author RAMIREDDY
	 * @see https://www.logicbig.com/how-to/code-snippets/jcode-spring-mvc-webmvcconfigurer.html
	 */
	class WebMvcConfig  implements WebMvcConfigurer{
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			registry.addResourceHandler("/**")
			.addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
		}
		@Override
	    public void addViewControllers(ViewControllerRegistry registry) {
	        //mapping '/' to index view name without a controller
	        ViewControllerRegistration r = registry.addViewController("/");
	        r.setViewName("index");
	    }

	    @Override
	    public void configureViewResolvers(ViewResolverRegistry registry) {
	        registry.jsp();//default prefix=/WEB-INF/", suffix=".jsp"
	    }

	}

}
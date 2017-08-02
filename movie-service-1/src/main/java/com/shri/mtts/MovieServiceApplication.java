package com.shri.mtts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.shri.mtts.externalresource.TheaterServiceResponseErrorHandler;

import ch.qos.logback.access.tomcat.LogbackValve;

/**
 * Start application
 * @author: shri
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class MovieServiceApplication {
	@Value("${theaterService.connecttimeout}")
	private int connectTimeout;

	@Value("${theaterService.readtimeout}")
	private int readTimeout;
    
	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate userServiceRestTemplate(TheaterServiceResponseErrorHandler errorHandler){
	HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
	requestFactory.setReadTimeout(readTimeout);
	requestFactory.setConnectTimeout(connectTimeout);
	RestTemplate template = new RestTemplate(requestFactory);
	template.setErrorHandler(errorHandler);
	return template;
	}
	
	@Bean
	public EmbeddedServletContainerFactory servletContainerFactory(){
		TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
		LogbackValve logbackValve = new LogbackValve();
		logbackValve.setFilename("logback-access.xml");
		tomcat.addContextValves(logbackValve);
		return tomcat;
	}
}

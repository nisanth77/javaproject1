package com.microservice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NameService {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public String getName() {

		CircuitBreaker cb = circuitBreakerFactory.create("name service breaer");
		return cb.run(() -> restTemplate.getForObject("http://localhost:8081/api/employee", String.class),
				throwable -> fallBackService());
		// String name = restTemplate.getForObject("http://localhost:8081/api/employee",
		// String.class);
		// return name;
	}

	public String fallBackService() {
		return "fall back name";
	}

}

package com.microservice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HomeController {
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/home")
public String home() {
	String product = restTemplate.getForObject("http://PRODUCT-MICROSERVICE/products", String.class);
	return product;
}
}

package com.microservice.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
 @GetMapping("/products")
	public String products() {
		return "products";
	}
}

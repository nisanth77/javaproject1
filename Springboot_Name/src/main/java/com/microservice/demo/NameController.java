package com.microservice.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameController {

	@GetMapping
	@RequestMapping("/api/employee")
	public String getName() {
		return "name from name api";
	}
}

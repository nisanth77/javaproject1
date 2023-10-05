package com.microservice.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.demo.dto.OrderRequest;
import com.microservice.demo.dto.OrderResponse;
import com.microservice.demo.entity.Customer;
import com.microservice.demo.repository.CustomerRepository;
import com.microservice.demo.repository.ProductRepository;

@RestController
public class OrderController {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;
    @PostMapping("/placeorder")
	public Customer placeOrder(@RequestBody OrderRequest request) {
		return customerRepository.save(request.getCustomer());
	}
	@GetMapping("/vieworder")
	public List<Customer> fndAllProduct() {
		return customerRepository.findAll();
	}
	
	@GetMapping("/getJoinQueryInfo")
	public List<OrderResponse> getJoinQueryInfo() {
		return customerRepository.getJoinInformation();
	}
}

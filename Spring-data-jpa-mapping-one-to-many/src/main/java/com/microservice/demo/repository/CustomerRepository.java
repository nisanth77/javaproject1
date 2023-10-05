package com.microservice.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.microservice.demo.dto.OrderResponse;
import com.microservice.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository< Customer, Integer> {

	@Query("Select new com.microservice.demo.dto.OrderResponse(c.name, p.productName) FROM Customer c join c.products p")
	public List<OrderResponse> getJoinInformation();
}

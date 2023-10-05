package com.microservice.demo.dto;

import com.microservice.demo.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class OrderRequest {
  public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

private Customer customer;

@Override
public String toString() {
	return "OrderRequest [customer=" + customer + "]";
}
public OrderRequest() {}
public OrderRequest(Customer customer) {
	super();
	this.customer = customer;
}
}

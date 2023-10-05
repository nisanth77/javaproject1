package com.microservice.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.demo.model.Employee;

@RestController
public class EmployeeController {
   
@Autowired	
private NameService nameService;
	@GetMapping
	@RequestMapping("/api/employee")
	public Employee getEmployee() {
		Employee emp = new Employee();
		String name = nameService.getName();
		emp.setName(name);
		emp.setSalary(1000);
		return emp;
	}
}

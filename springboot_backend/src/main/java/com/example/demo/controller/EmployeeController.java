package com.example.demo.controller;




import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
/*
 * @Restcontroller annotation is convenient because it combines @controller
 * and @responsebody annotation
 */
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeservice;

	public EmployeeController(EmployeeService employeeservice) {
		super();
		this.employeeservice = employeeservice;
	}

//build create employee rest api
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeservice.saveEmployee(employee), HttpStatus.CREATED);
	}
	
//build all employees rest api
	@GetMapping
	public List<Employee> getAllEmployee() {
		return employeeservice.getAllEmployees();
	}
//bulid find the employee by id using rest api
	//http://localhost:8080/api/employees/1
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long empId) {
		return new ResponseEntity<Employee>(employeeservice.getEmployeeById(empId),HttpStatus.OK);
		
	}
	
//build update employee rest api
	@PutMapping("/{id}")
	//http://localhost:8080/api/employees/1
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeservice.updateEmployee(employee, id), HttpStatus.OK);
	}
	//build delete employee rest api
	@DeleteMapping("/{id}")
	//http://localhost:8080/api/employees/1
	public ResponseEntity<String> deleteEmployee( @PathVariable long id) {
		employeeservice.deleteEmployee(id);
		return new ResponseEntity<String>("Delete successfully", HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.demo.respository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRespository;

	@PostMapping("/employees")
	public String createNewEmployee(@RequestBody Employee employee) {
		employeeRespository.save(employee);
		return "Employee created in database";
	}

	@GetMapping("/getemployees")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> empList = new ArrayList<>();
		employeeRespository.findAll().forEach(empList::add);
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);
	}

	@GetMapping("/getemployees/{empid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long empid) {
		Optional<Employee> emp = employeeRespository.findById(empid);
		if (emp.isPresent())
			return new ResponseEntity<Employee>(emp.get(), HttpStatus.OK);

		else
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/updateemployee/{empid}")
	public String updateEmployeeByid(@PathVariable long empid, @RequestBody Employee employee) {

		long id = empid;
		Optional<Employee> emp = employeeRespository.findById(id);
		if (emp.isPresent()) {
			Employee empExist = emp.get();
			empExist.setEmp_name(employee.getEmp_name());
			empExist.setEmp_salary(employee.getEmp_salary());
			empExist.setEmp_age(employee.getEmp_age());
			empExist.setEmp_city(employee.getEmp_city());
			employeeRespository.save(empExist);
			return "Employee is updated in " + id;
		} else
			return "Employee id is not present in " + id;
	}

	@DeleteMapping("/deleteemployee/{empid}")
	public String deleteEmployee(@PathVariable long empid) {

		employeeRespository.deleteById(empid);
		return "Employee is deleted successfully";
	}

	@DeleteMapping("/deleteallemployee")
	public String deleteAllEmployee() {
		employeeRespository.deleteAll();
		return "Employee fully deleted successfully";
	}
}

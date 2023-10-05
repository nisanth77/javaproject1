package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Employee;
import com.example.demo.respository.EmployeeRespository;
import com.example.demo.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
//we don't need to provide @transactional  because spirng internally provide all its methods 
@Transactional
public class EmployeeServiceimpl implements EmployeeService {
	/*
	 * Starting with spring 4.3, if a class which is configured as a Spring bean has
	 * only one constructor , the @Autowired annotation can be omitted and spring
	 * will use that constructor and inject all necessary dependencies
	 */
	@Autowired
	private EmployeeRespository employeeRespository;

	public EmployeeServiceimpl(EmployeeRespository employeeRespository) {
		super();
		this.employeeRespository = employeeRespository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRespository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRespository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		/*Optional<Employee> empId = employeeRespository.findById(id);
		if (empId.isPresent())
			return empId.get();
		else
			throw new ResourceNotFoundException("Employee", "Id", empId); */
		
		
		//lambada expression
		return employeeRespository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Employee", "Id", id));

	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// we need to check whether the given employee id is present in DB or not
		  Employee existingEmployee = employeeRespository.findById(id).orElseThrow(() -> 
		       new ResourceNotFoundException("Employee", "Id", id));
		  existingEmployee.setFirstName(employee.getFirstName());
		  existingEmployee.setLastName(employee.getLastName());
		  existingEmployee.setEmail(employee.getEmail());
		  employeeRespository.save(existingEmployee);
		return existingEmployee;
		
	}

	@Override
	public void deleteEmployee(long id) {
		// check whether the employee is present or not 
		employeeRespository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		employeeRespository.deleteById(id);
		
	}

}

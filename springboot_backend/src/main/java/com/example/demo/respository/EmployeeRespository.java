package com.example.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Employee;

/*we don't have to add addrespository annotation because spring jpa 4.3 has already 
has that adding repository  annotation internally */

public interface EmployeeRespository extends JpaRepository<Employee, Long> {

}

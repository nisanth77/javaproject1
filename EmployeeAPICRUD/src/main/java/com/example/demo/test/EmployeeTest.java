package com.example.demo.test;





import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.model.Employee;

class EmployeeTest {

     Employee employee;

    @BeforeEach
    void setUp() {
        employee = new Employee(1L, "John Doe", 50000.0f, 30, "New York");
    }

    @Test
    void testGettersAndSetters() {
        assertEquals(1L, employee.getId());
        assertEquals("John Doe", employee.getEmp_name());
        assertEquals(50000.0f, employee.getEmp_salary(), 0.01);
        assertEquals(30, employee.getEmp_age());
        System.out.println(employee.getEmp_age());
        assertEquals("New York", employee.getEmp_city());

        employee.setId(2L);
        employee.setEmp_name("Jane Smith");
        employee.setEmp_salary(60000.0f);
        employee.setEmp_age(28);
        employee.setEmp_city("Los Angeles");

        assertEquals(2L, employee.getId());
        assertEquals("Jane Smith", employee.getEmp_name());
        assertEquals(60000.0f, employee.getEmp_salary(), 0.01);
        assertEquals(28, employee.getEmp_age());
        assertEquals("Los Angeles", employee.getEmp_city());
    }
}


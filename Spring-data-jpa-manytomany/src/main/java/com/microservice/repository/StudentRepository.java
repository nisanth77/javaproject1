package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}

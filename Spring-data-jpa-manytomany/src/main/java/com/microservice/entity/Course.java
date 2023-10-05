package com.microservice.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {

	public Course() {}
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String abbservation;
	private int modules;
	private double price;
	@ManyToMany(mappedBy = "course", fetch = FetchType.LAZY)
	private Set<Student> students;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbbservation() {
		return abbservation;
	}

	public void setAbbservation(String abbservation) {
		this.abbservation = abbservation;
	}

	public int getModules() {
		return modules;
	}

	public void setModules(int modules) {
		this.modules = modules;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
   
	public Course(Long id, String title, String abbservation, int modules, double price, Set<Student> students) {
		super();
		this.id = id;
		this.title = title;
		this.abbservation = abbservation;
		this.modules = modules;
		this.price = price;
		this.students = students;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", abbservation=" + abbservation + ", modules=" + modules
				+ ", price=" + price + ", students=" + students + "]";
	}
	
	
	
}

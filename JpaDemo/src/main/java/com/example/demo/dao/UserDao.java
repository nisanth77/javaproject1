package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Userdetails;

public interface UserDao extends CrudRepository<Userdetails, Integer> 
{

}

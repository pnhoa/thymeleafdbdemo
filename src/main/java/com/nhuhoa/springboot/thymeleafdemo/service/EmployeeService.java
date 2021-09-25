package com.nhuhoa.springboot.thymeleafdemo.service;

import java.util.List;

import com.nhuhoa.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee theEmployee);

	public void deleteById(int theId);
	
	public Employee findByEmail(String theEmail);
}

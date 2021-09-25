package com.nhuhoa.springboot.thymeleafdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nhuhoa.springboot.thymeleafdemo.dao.EmployeeRepository;
import com.nhuhoa.springboot.thymeleafdemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl( EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int theId) {
		
		Employee theEmployee = employeeRepository.findById(theId);
		
		if(theEmployee == null) {
			throw new RuntimeException("Not found employee with id " +theId);
		}
		
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

	@Override
	public Employee findByEmail(String theEmail) {
Employee theEmployee = employeeRepository.findByEmail(theEmail);
		
		if(theEmployee == null) {
			throw new RuntimeException("Not found employee with email: " +theEmail);
		}
		
		return theEmployee;
	}

}

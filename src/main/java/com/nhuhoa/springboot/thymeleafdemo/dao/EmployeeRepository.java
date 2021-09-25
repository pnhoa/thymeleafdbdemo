package com.nhuhoa.springboot.thymeleafdemo.dao;

import java.util.List;

import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nhuhoa.springboot.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code
	
	// add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
	
	// custom spring data jpa: method findById
	public Employee findById(int theId);
	
	// custom spring data jpa with @Query
	@Query("select e from Employee e where e.email = ?1")
	public Employee findByEmail(String theEmail);
	
	// custom spring data jpa Sort
	 @Query("select e from Employee e where e.lastName like ?1%")
	  List<Employee> findByAndSort(String lastName, JpaSort sort);

}

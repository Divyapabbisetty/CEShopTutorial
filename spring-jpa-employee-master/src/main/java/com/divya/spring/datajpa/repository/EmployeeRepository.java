package com.divya.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.divya.spring.datajpa.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findByOnBench(boolean onBench);
	List<Employee> findByFirstNameContaining(String firstName);
}

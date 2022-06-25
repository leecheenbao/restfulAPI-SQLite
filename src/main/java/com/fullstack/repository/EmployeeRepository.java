package com.fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

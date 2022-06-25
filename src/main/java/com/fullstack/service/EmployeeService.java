package com.fullstack.service;

import java.util.List;

import com.fullstack.dto.EmployeeDTO;
import com.fullstack.model.Employee;

public interface EmployeeService {

	List<EmployeeDTO> findAll();

	Employee findOne(String name);

	void save(EmployeeDTO employeeDTO);

	void delete(String name);
}

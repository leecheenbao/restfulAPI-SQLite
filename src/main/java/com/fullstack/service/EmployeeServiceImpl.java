package com.fullstack.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.fullstack.dto.EmployeeDTO;
import com.fullstack.model.Employee;
import com.fullstack.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeDTO> findAll() {
		List<Employee> employees = employeeRepository.findAll();
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		for (Employee employee : employees) {
			Date date = employee.getDateOfBirth();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateOfBirth = sdf.format(date);

			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO.setName(employee.getName());
			employeeDTO.setDateOfBirth(dateOfBirth);
			employeeDTO.setSalary(employee.getSalary());
			employeeDTO.setAddress(employee.getAddress());
			employeeDTOs.add(employeeDTO);
		}
		return employeeDTOs;
	}

	@Override
	public void save(EmployeeDTO employeeDTO) {

	
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(employeeDTO.getDateOfBirth());
			
			Employee employee = new Employee();
			employee.setName(employeeDTO.getName());
			employee.setDateOfBirth(date);
			employee.setSalary(employeeDTO.getSalary());
			employee.setAddress(employeeDTO.getAddress());
			employeeRepository.save(employee);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Employee findOne(String name) {
		Employee employee = new Employee();
		employee.setName(name);
		Example example = Example.of(employee);

		Optional<Employee> employeeOptional = employeeRepository.findOne(example);
		if (employeeOptional.isPresent())
			employee = employeeOptional.orElseThrow(null);
		return employee;
	}

	@Override
	public void delete(String name) {
		Employee employee = new Employee();
		employee.setName(name);
		Example example = Example.of(employee);
		employeeRepository.delete(employee);
	}

}
package com.fullstack.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fullstack.dto.EmployeeDTO;
import com.fullstack.model.Employee;
import com.fullstack.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/getEmp")
	public List<EmployeeDTO> getEmployee() {
		List<EmployeeDTO> employeeDTOs = employeeService.findAll();

		System.out.println(employeeDTOs);
		return employeeDTOs;
	}

	@PostMapping("/create")
	public void create(@RequestBody List<EmployeeDTO> employeeDTOs) {
		for (EmployeeDTO employeeDTO : employeeDTOs) {
			employeeService.save(employeeDTO);
		}
	}






}
package com.fullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fullstack.service.EmployeeService;

@RequestMapping
@Controller
public class HomeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/index")
	public String index(Model model) {
		return "index";
	}

}
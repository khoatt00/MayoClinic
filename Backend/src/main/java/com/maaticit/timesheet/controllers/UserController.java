package com.maaticit.timesheet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maaticit.timesheet.dto.EmployeeDto;
import com.maaticit.timesheet.entity.Employee;
import com.maaticit.timesheet.service.EmployeeService;



@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/user")
	public void employeeAdd(@RequestBody EmployeeDto employeeDto) {
		employeeService.addEmployee(employeeDto);
		
	}


	
}

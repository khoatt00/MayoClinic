package com.maaticit.timesheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maaticit.timesheet.entity.Employee;
import com.maaticit.timesheet.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Autowired
	EmployeeRepository employeeRepo;

	@Override
	public void addEmployee(List<Employee> employee) {
			employeeRepo.save(employee);
			
	}
		
}

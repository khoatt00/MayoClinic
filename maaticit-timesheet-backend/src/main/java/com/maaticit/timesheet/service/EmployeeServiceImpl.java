package com.maaticit.timesheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maaticit.timesheet.model.Employee;
import com.maaticit.timesheet.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
		@Autowired
		EmployeeRepo employeeRepo;

		@Override
		public void addEmployee(List<Employee> employee) {
				employeeRepo.save(employee);
				
		}
		
	

}

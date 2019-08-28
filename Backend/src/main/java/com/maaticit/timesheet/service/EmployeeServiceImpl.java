package com.maaticit.timesheet.service;

import java.util.ArrayList;
import java.util.List;

	
	import org.springframework.beans.BeanUtils;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;

import com.maaticit.timesheet.Exception.InvalidRequestException;
import com.maaticit.timesheet.dto.EmployeeDto;

import com.maaticit.timesheet.entity.Employee;
import com.maaticit.timesheet.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;

	private void mapEmployeeDetails(Object source, Object destination) {
		BeanUtils.copyProperties(source, destination);
	}

	public boolean validatePassword(EmployeeDto employeeDto) {
		return (employeeDto.getPassword().equals(employeeDto.getConfirmPassword()));

	}

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) throws InvalidRequestException {
		Employee employee = new Employee();
		boolean validatePassword = false;
		validatePassword = validatePassword(employeeDto);
		if (validatePassword) {
			mapEmployeeDetails(employeeDto, employee);
			employeeRepo.save(employee);
			mapEmployeeDetails(employee, employeeDto);
			return employeeDto;
		} else {
			throw new InvalidRequestException("password miss-match");
		}
	}

	@Override
	public EmployeeDto getEmployeeById(int id) {
		Employee employee = employeeRepo.findById(id).get();

		EmployeeDto employeeDto = new EmployeeDto();
		mapEmployeeDetails(employee, employeeDto);
		return employeeDto;

	}


		@Override
		public List<EmployeeDto> getAllEmployee() {
			// TODO Auto-generated method stub
			return null;
		}
	

}

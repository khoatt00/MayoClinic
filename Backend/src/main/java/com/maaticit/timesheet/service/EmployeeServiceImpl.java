package com.maaticit.timesheet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public void validateProperEmail(EmployeeDto employeeDto) throws InvalidRequestException {
		String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		if (!pattern.matcher(employeeDto.getEmail()).matches()) {
			throw new InvalidRequestException("Please provide valid email address");
		}

	}

	public void validateEmployee(EmployeeDto employeeDto) throws InvalidRequestException {
		if (employeeDto.getName() == null) {
			throw new InvalidRequestException("name cannot be empty");
		} else if (employeeDto.getPhone() == null) {
			throw new InvalidRequestException("Phone cannot be empty");
		} else if (employeeDto.getAddress() == null) {
			throw new InvalidRequestException("Address cannot be empty");

		} else if (employeeDto.getRole() == null) {
			throw new InvalidRequestException("Role cannot be empty");
		} else if (!employeeDto.getConfirmPassword().equals(employeeDto.getPassword())) {

			throw new InvalidRequestException("confirm password miss-matched ");
		} else if (employeeDto.getEmail() == null) {
			throw new InvalidRequestException("Email cannot be empty");
		} else {
			validatePassword(employeeDto.getPassword());
			validateUserName(employeeDto.getUsername());
			validateProperEmail(employeeDto);

		}

	}

	private void validatePassword(String password) throws InvalidRequestException  {
		if(password == null) {
			throw new InvalidRequestException("password cannot be null");
		}
		if(password.length() < 8) {
			throw new InvalidRequestException("Password should have 8 characters");
		}
		
		Pattern letter = Pattern.compile("[a-zA-z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");


       Matcher hasLetter = letter.matcher(password);
       Matcher hasDigit = digit.matcher(password);
       Matcher hasSpecial = special.matcher(password);
       
       if(!hasLetter.find() || !hasDigit.find() || !hasSpecial.find()) {
    	   throw new InvalidRequestException("Password should contain at least 1 letter and 1 special character");
       }
	}

	private void validateUserName(String username) throws InvalidRequestException {
		if (username == null) {

			throw new InvalidRequestException("Username cannot be empty");
		} else if (username.length() < 10) {
			throw new InvalidRequestException("User name requires atleast 10 characters");
		}

	}

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) throws InvalidRequestException {
		Employee employee = new Employee();
		validateEmployee(employeeDto);
		mapEmployeeDetails(employeeDto, employee);
		employeeRepo.save(employee);
		mapEmployeeDetails(employee, employeeDto);
		return employeeDto;

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
		List<EmployeeDto> employeeDtos = new ArrayList<>();
		List<Employee> employees = (List<Employee>) employeeRepo.findAll();
		for (Employee employee : employees) {
			EmployeeDto employeeDto = new EmployeeDto();
			mapEmployeeDetails(employee, employeeDto);
			employeeDtos.add(employeeDto );
		}
		return employeeDtos;
	}

	@Override
	public void deleteEmployeeById(int id) {
		employeeRepo.deleteById(id);

	}
	
	@Override
	public void updateEmployeeById(int id) {
		employeeRepo.updateById(id);
	
	}
}

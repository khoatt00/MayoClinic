package com.maaticit.timesheet.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maaticit.timesheet.Exception.MaaticTimesheetException;
import com.maaticit.timesheet.dto.EmployeeDto;
import com.maaticit.timesheet.entity.Response;
import com.maaticit.timesheet.entity.TimesheetFile;
import com.maaticit.timesheet.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/user")
	public void employeeAdd(@RequestBody EmployeeDto employeeDto) throws MaaticTimesheetException {
		employeeService.addEmployee(employeeDto);

	}

	@RequestMapping(value = "user/timesheet", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Response> saveFile(@RequestParam("file") MultipartFile file)
			throws JsonParseException, JsonMappingException, IOException {
		TimesheetFile timesheetFile = new TimesheetFile();
		timesheetFile.setFile(file.getBytes());
		timesheetFile.setFilename(file.getOriginalFilename());
		TimesheetFile tFile = employeeService.saveFile(timesheetFile);
		if (tFile != null) {
			return new ResponseEntity<Response>(new Response("file is saved successfully"), HttpStatus.OK);
		} else {
			return new ResponseEntity<Response>(new Response("file is not saved"), HttpStatus.OK);
		}

	}

	@GetMapping("/user")
	public List<EmployeeDto> getAllEmployee() {
		return employeeService.getAllEmployee();

	}

	@GetMapping("/user/{id}")
	public EmployeeDto getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}
}

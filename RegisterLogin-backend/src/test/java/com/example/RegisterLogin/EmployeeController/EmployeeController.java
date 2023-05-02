package com.example.RegisterLogin.EmployeeController;
import org.springframework.web.bind.annotation.RestController;

import com.example.RegisterLogin.EmployeeDTO.EmployeeDTO;
import com.example.RegisterLogin.Service.EmployeeService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.*;
@RestController
@CrossOrigin
@RequestMapping("/student")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(path="/add")
	public String saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
		String id = employeeService.addEmployee(employeeDTO);
		return id;
	}
//	public String add(@RequestBody Employee employee) {
//		studentService.saveStudent(employee);
//		return "New Student is added";
//	}
	
}

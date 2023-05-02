package com.example.RegisterLogin.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.RegisterLogin.EmployeeDTO.EmployeeDTO;
import com.example.RegisterLogin.Entity.Employee;
import com.example.RegisterLogin.Repo.EmployeeRepo;
import com.example.RegisterLogin.Service.EmployeeService;
@Service
public class EmployeeIMPL implements EmployeeService{
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String addEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee(
			employeeDTO.getEmployeeid(),
			employeeDTO.getEmployeename(),
			employeeDTO.getEmail(),
			this.passwordEncoder.encode(employeeDTO.getPassword()));
		employeeRepo.save(employee);
		return employee.getEmployeename();
	}
}

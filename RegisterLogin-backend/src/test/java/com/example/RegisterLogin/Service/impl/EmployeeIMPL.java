package com.example.RegisterLogin.Service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.RegisterLogin.EmployeeDTO.EmployeeDTO;
import com.example.RegisterLogin.EmployeeDTO.LoginDTO;
import com.example.RegisterLogin.Entity.Employee;
import com.example.RegisterLogin.Repo.EmployeeRepo;
import com.example.RegisterLogin.Service.EmployeeService;
import com.example.RegisterLogin.response.LoginResponse;
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
	@Override
	public LoginResponse loginEmployee(LoginDTO loginDTO) {
		String msg="";
		Boolean status;
		Employee employee1 = employeeRepo.findByEmail(loginDTO.getEmail());
		if(employee1!=null) {
			String password = loginDTO.getPassword();
			String encodedPassword = employee1.getPassword();
			Boolean isPasswordRight = passwordEncoder.matches(password, encodedPassword);
			if(isPasswordRight) {
				Optional<Employee>employee=employeeRepo.findOneByEmailAndPassword(loginDTO.getEmail(),loginDTO.getPassword());
				if(employee.isPresent()) {
					return new LoginResponse (msg="Login success",status=true)
				}
				else {
					return new LoginResponse(msg="Login failed",status=false);
				}
			}
			else {
				return new LoginResponse(msg="password doesn't match",status=false)
			}
		}
		else {
			return new LoginResponse(msg="Email doesn't exist",status=false);
		}
	}
}

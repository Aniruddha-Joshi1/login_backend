package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.EmployeeDTO.EmployeeDTO;
import com.example.RegisterLogin.EmployeeDTO.LoginDTO;
import com.example.RegisterLogin.response.LoginResponse;

public interface EmployeeService {
	String addEmployee(EmployeeDTO employeeDTO);
	LoginResponse loginEmployee(LoginDTO loginDTO);
}

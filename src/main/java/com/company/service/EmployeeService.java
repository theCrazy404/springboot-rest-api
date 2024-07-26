package com.company.service;

import java.util.List;

import com.company.dto.EmployeeDTO;
import com.company.entity.Employee;

public interface EmployeeService {

	String createEmployee(EmployeeDTO emp);
	List<Employee> readEmployees();
	boolean deleteEmployee(Long id);
	
	String putMethodName(Long id,EmployeeDTO emp);
}

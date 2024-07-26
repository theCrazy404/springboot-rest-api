package com.company.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.dto.EmployeeDTO;
import com.company.entity.Employee;
import com.company.service.EmployeeService;

@RestController
public class EmpAPI {
	
	@Autowired
	EmployeeService empService;
	
//	List<Employee> employees = new ArrayList<>();
	
	@GetMapping("employees")
	public List<Employee> getAllEmployees() {
		
		List<Employee> employees = empService.readEmployees();
		return employees;
	}
	
	@PostMapping("employee")
	public String createEmployee(@RequestBody EmployeeDTO employee)
	{
		empService.createEmployee(employee);
		return "Saved Successfully...";
	}
	
	@DeleteMapping("employees/{id}")
	public String deleteEmployee(@PathVariable Long id)
	{
	
		
		if(empService.deleteEmployee(id))
			return "Delete Successfully";
		return "Not found";
		
	}
	@PutMapping("employees/{id}")
	public String putMethodName(@PathVariable Long id, @RequestBody EmployeeDTO employee)
	{
		return empService.putMethodName(id, employee);
		
		
	}

}

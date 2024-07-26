package com.company.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dto.EmployeeDTO;
import com.company.entity.Employee;
import com.company.repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public String createEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub
		
		
		Employee e1 = new Employee();
		e1.setName(emp.getName());
		e1.setEmail(emp.getEmail());
		e1.setPhone(emp.getPhone());
		repo.save(e1);
		return "Saved Successfully...";
	}

	@Override
	public List<Employee> readEmployees() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public boolean deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		Employee emp = repo.findById(id).get();
		repo.delete(emp);
		return true;
	}

	@Override
	public String putMethodName(Long id, EmployeeDTO emp) {
		Employee e1 = repo.findById(id).get();
		e1.setEmail(emp.getEmail());
		e1.setName(emp.getName());
		e1.setPhone(emp.getPhone());
		repo.save(e1);
		return "update successfully...";
	}

}

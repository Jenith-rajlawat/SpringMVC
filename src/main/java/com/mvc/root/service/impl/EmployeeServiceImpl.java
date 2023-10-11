package com.mvc.root.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.root.model.Employee;
import com.mvc.root.repository.EmployeeRepository;
import com.mvc.root.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepo;
	
	@Override
	public void addEmp(Employee emp) {
		
		employeeRepo.save(emp);
	}

	@Override
	public void updateEmp(Employee emp) {
		employeeRepo.save(emp);
	}

	@Override
	public void deleteEmp(Long id) {
		employeeRepo.deleteById(id);
		
	}

	@Override
	public Employee getEmpById(Long id) {
		
		return employeeRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmps() {
		
		return employeeRepo.findAll();
	}

}

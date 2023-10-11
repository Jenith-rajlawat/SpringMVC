package com.mvc.root.service;

import java.util.List;

import com.mvc.root.model.Employee;

public interface EmployeeService {

	void addEmp(Employee emp);
	
	void updateEmp(Employee emp);
	
	void deleteEmp(Long id);
	
	Employee getEmpById(Long id);
	
	List<Employee> getAllEmps();
}

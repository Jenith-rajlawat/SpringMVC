package com.mvc.root.service;

import java.util.List;

import com.mvc.root.model.Department;

public interface DepartmentService {

	void addDept(Department dept);
	
	void deleteDept(int id);
	
	void updateDept(Department dept);
	
	Department getById(int id);
	
	List<Department> getAllDept();
	
	
}

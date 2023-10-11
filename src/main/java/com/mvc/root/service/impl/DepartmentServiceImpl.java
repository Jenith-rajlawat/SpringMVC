package com.mvc.root.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.root.model.Department;
import com.mvc.root.repository.DepartmentRepository;
import com.mvc.root.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Override
	public void addDept(Department dept) {
		departmentRepository.save(dept);
		
	}

	@Override
	public void deleteDept(int id) {
		departmentRepository.deleteById(id);
		
	}

	@Override
	public void updateDept(Department dept) {
		departmentRepository.save(dept); //sidhai update garne xaina so changes haldera save garnu parxa just like add
		
	}

	@Override
	public Department getById(int id) {
		
		return departmentRepository.findById(id).get();//Optional pathauxa so to get object we do .get()
	}

	@Override
	public List<Department> getAllDept() {
		
		return departmentRepository.findAll();
	}

}

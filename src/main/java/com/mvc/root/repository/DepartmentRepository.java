package com.mvc.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.root.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	

}

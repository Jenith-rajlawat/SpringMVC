package com.mvc.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mvc.root.model.Employee;

//<class name type, tesko primary id ko types>
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

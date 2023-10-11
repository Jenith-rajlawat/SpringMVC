package com.mvc.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.root.model.Department;
import com.mvc.root.model.Employee;
import com.mvc.root.service.DepartmentService;
import com.mvc.root.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	
	@GetMapping("/employee")
	public String getEmployee(Model model) {
		
		model.addAttribute("dList", departmentService.getAllDept());
		
		return "EmployeeForm";
	}
	
	@PostMapping("/employee")
	public String postEmployee(@ModelAttribute Employee employee ) {
		
		employeeService.addEmp(employee);
		
		return "redirect:/employee";
	}
	
	
	@GetMapping("/empList")
	public String getEmpList(Model model) {
		
		model.addAttribute("empList",employeeService.getAllEmps());
		return "EmployeeList";
	}
	
	@GetMapping("/emp/delete")
	public String delete(@RequestParam Long id) {
		
		employeeService.deleteEmp(id);
		
		return "redirect:/empList";
	}
	
	@GetMapping("/emp/edit")
	public String edit(@RequestParam Long id ,Model model) {
		
		
		
		model.addAttribute("emodel",employeeService.getEmpById(id));
		model.addAttribute("dList", departmentService.getAllDept());
		return "EmployeeEditForm";
	}
	
	@PostMapping("/emp/update")
	public String update(@ModelAttribute Employee emp, Model model) {
		
		
		employeeService.updateEmp(emp);
		
		return "redirect:/empList";
	}
		
	
	
	

}

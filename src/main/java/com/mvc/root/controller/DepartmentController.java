package com.mvc.root.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.root.model.Department;
import com.mvc.root.service.DepartmentService;

@Controller
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;
	
	
	@GetMapping("/department")
	public String getDepartment() {
		return "DepartmentForm";
	}
	
	@PostMapping("/department")
	public String postDepartment(@ModelAttribute Department dept,Model model) {
	if(dept!=null) {
		deptService.addDept(dept);
		model.addAttribute("message","Successfully added");
		return "DepartmentForm";}
	else {
		model.addAttribute("message","Failed to add");
		return "DepartmentForm";}
	}
	
	
	
	
	@GetMapping("/deptList")
	public String getList(Model model) {
		
		model.addAttribute("dList",deptService.getAllDept());
		return "DepartmentList";
	}
	
	
	@GetMapping("/dept/delete")
	public String delete(@RequestParam int id) {
		
		deptService.deleteDept(id);
		
		return "redirect:/deptList";
	}
	
	@GetMapping("/dept/edit")
	public String edit(@RequestParam int id,Model model) {
		
		model.addAttribute("dmodel",deptService.getById(id));
		return "DepartmentEditForm";
	}
	
	
	@PostMapping("/dept/update")
	public String update(@ModelAttribute Department dept) {
		
		deptService.updateDept(dept);
		
		return "redirect:/deptList";
	}
		
	@GetMapping("/dept/excel")
	public String excel() {
		
		return "";
	}
	
	@GetMapping("/dept/pdf")
	public String pdf() {
		
		return "";
	}
	
		
	}
	
	


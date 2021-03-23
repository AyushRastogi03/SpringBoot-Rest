package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.pojo.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentRestController {
	@Autowired
	private StudentService stu ;
	
//	@GetMapping("/fetch")
//	public List<Student> findAll(){
//		return stu.findAll();
//	}
	
	
	@GetMapping("/{role}")
	public List<Student> findByRole(@PathVariable("role") String role){
		return stu.findByRole(role);
	}
	
	@GetMapping("/onboarded={onboarded}")
	public List<Student> findOnboarded(@PathVariable("onboarded") boolean onboarded){
		return stu.findOnboarded(onboarded);
	}
	
	
	@GetMapping("/onboarded")
	public List<Student> writeOnboarded(boolean onboarded)
	{
		return stu.writeOnboarded(onboarded);
	}
	
	
	@PostMapping("/company")
	public List<Student> addCompany(@RequestBody List<Student> student){
		stu.addCompany(student);
		return student;
	}
	
	
	@GetMapping("/fetch")
	public List<Student> searchData(@RequestParam(value="firstName" , required=false , defaultValue="null") String firstName ,
			@RequestParam(value="lastName" , required=false , defaultValue="null") String lastName ,
			@RequestParam(value="role" , required=false , defaultValue="null") String role ,
			@RequestParam(value="company" , required=false , defaultValue="null") String company ,
			@RequestParam(value="age" , required=false , defaultValue="0") int age ,
			@RequestParam(value="onboarded" , required=false ) boolean onboarded){
		
		if(firstName.equals("null")&&lastName.equals("null")&&role.equals("null")&&company.equals("null")&&age==0) {
			return stu.findAll();
		}
		
		return stu.searchData(firstName, lastName, role, company, age, onboarded);
		
	}
	
	
	
	
	
	
	
	
	
	
	

		
		
	
}



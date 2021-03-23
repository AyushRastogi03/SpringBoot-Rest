package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.Student;

public interface StudentService {
	
	public List<Student> findAll();
	public List<Student> findByRole(String role);
	public List<Student> findOnboarded(boolean onboarded);
	public List<Student> writeOnboarded(boolean onboarded);
	public void addCompany(List<Student> student);
	public List<Student> searchData(String firstName, String lastName, String role, String company, int age, boolean onboarded);

}

package com.example.demo.pojo;

public class Student {  // pojo class

	private String firstName ;
	private String lastName;
	private String role;
	private String company;
	private int age ;
	private boolean onboarded ;
	
	public Student() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isOnboarded() {
		return onboarded;
	}

	public void setOnboarded(boolean onboarded) {
		this.onboarded = onboarded;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", role=" + role + ", company=" + company
				+ ", age=" + age + ", onboarded=" + onboarded + "]";
	}
	

	

}

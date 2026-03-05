package com.lpu.emp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class EmployeeDTO {
	
	@NotBlank(message = "Name should not be blanked")
	private String name;
	
	@Positive
	@Pattern(regexp = "^[0-9]{10}$", message="Number Invalid")
	private String phone;
	
	@Email(message = "Email should contain @ and .com")
	private String email;
	
	@Min(value = 18)
	@Max(value = 60)
	private int age;
	
	
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}

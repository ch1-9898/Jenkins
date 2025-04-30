package com.example.dto;


public class LoginDTO {
	String name;
	int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public LoginDTO(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public LoginDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "LoginDTO [name=" + name + ", age=" + age + "]";
	}
	

}

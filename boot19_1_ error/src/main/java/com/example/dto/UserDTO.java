package com.example.dto;

import java.time.LocalDate;

public class UserDTO{
	//id password  birthday

	private String id;

	private String password;

	private LocalDate birthday;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO(String id, String password, LocalDate birthday) {
		super();
		this.id = id;
		this.password = password;
		this.birthday = birthday;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "ResigterDTO [id=" + id + ", password=" + password + ", birthday=" + birthday + "]";
	}
	
	
}

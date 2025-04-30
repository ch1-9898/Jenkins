package com.example.dto;

import java.time.LocalDate;
import java.time.Period;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserDTO{
	//id password  birthday
	@NotNull
	@Size(min = 5, message = "최소5자 이상 입력하세요")
	private String id;
	@NotNull
	@Pattern(
			regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
			message = "영어, 숫자, 특수문자 포함 8자 이상"
			)
	private String password;
	@NotNull
	@Past(message = "생년월일은 현재 날짜 이전이어야함")	
	private LocalDate birthday;
	/////////////////////////////////////////
	public boolean isValidBirthDay() {  //controller에서 호출함
		
		int age= Period.between(this.birthday, LocalDate.now()).getYears();
		age++;
		//2025년 이전 출생이고 나이는 15세 이상 인 경우 오류 있으면 false
		boolean result= this.birthday.isBefore(LocalDate.of(2025, 2, 13)) && age>=1;
		System.out.println("isValidBirthDay실행======   age="+age+"  결과: "+ result);
		return result;
	}
	
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

package com.example.validator;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.dto.UserDTO;

@Component
public class UserValidator implements Validator {
	

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserDTO.class.isAssignableFrom(clazz);
		//Spring Validator에서 검증 가능한지 확인 
//		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDTO userDTO= (UserDTO)target;
		 if (userDTO.getId() == null || userDTO.getId().length() < 5 ) {
			 errors.rejectValue("id", "id.size", "id는 5자 이상");
		 }
		 // Password 검증 (영어, 숫자, 특수문자 포함)
		 if (userDTO.getPassword() == null || !userDTO.getPassword().matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
			    errors.rejectValue("password", "password.pattern", "Password는 영어, 숫자, 특수문자를 포함해야 합니다.");
			}
	        
	      if (userDTO.getBirthday() == null) {
	            errors.rejectValue("birthday", "birthday.notEmpty", "생일을 입력해주세요.");
	      } else {
	           LocalDate birthDate = LocalDate.parse(userDTO.getBirthday().toString());
	            int age = Period.between(birthDate, LocalDate.now()).getYears();
	            if (age < 1) {
	                errors.rejectValue("birthday", "birthday.age", "사용자는 1세 이상이어야 합니다.");
	            }
	      }
	}
}

package com.example.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.UserDTO;
import com.example.validator.UserValidator;

import jakarta.validation.Valid;



@Controller
public class HelloController {
	
	@Autowired
	UserValidator userValidator;///////////////////
	
	@GetMapping("/registerForm")
	public String showForm(Model model) {//////
		//주소요청시 사용할 빈을 생성 후 jsp에 넘김
		model.addAttribute("userDTO", new UserDTO("abcde", "aaaabbbb**12**", LocalDate.now().minusYears(20))); /////
		return "registerForm";
	}//end main
	
	@PostMapping("/register")
	public String register(  UserDTO userDTO, BindingResult bindingResult,Model model ) {
		//@Validator 빠짐
		System.out.println("/register 요청 : " + userDTO);
		userValidator.validate(userDTO, bindingResult);/////////
		String page="success";
		String mesg="";
		if(bindingResult.hasErrors()) { //문제 있는 경우 
			page="registerForm";
			mesg="폼 데이터 입력에 문제가 발생하였습니다";
		}		
	
		System.out.println("page : "+ page);
		model.addAttribute("userDTO", userDTO);
		model.addAttribute("mesg", mesg);
		return page;				
	}//end main

}

package com.example.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dto.UserDTO;

import jakarta.validation.Valid;



@Controller
public class HelloController {
	
	@GetMapping("/registerForm")
	public String showForm(Model model) {//////
		//주소요청시 사용할 빈을 생성 후 jsp에 넘김
		model.addAttribute("userDTO", new UserDTO("abcde", "aaaabbbb**12", LocalDate.now().minusYears(20))); /////
		return "registerForm";
	}//end main
	
	@PostMapping("/register")
	public String register(@Valid  UserDTO userDTO, BindingResult bindingResult,Model model ) {
		System.out.println("/register 요청 : " + userDTO);
		String page="success";
		String mesg="";
		if(bindingResult.hasErrors()) { //문제 있는 경우 
			page="registerForm";
			mesg="폼 데이터 입력에 문제가 발생하였습니다";
		}
		
		boolean result= userDTO.isValidBirthDay(); //나이검증 직접 호출
		
//		String page="success";
		if(!result) {
			page="registerForm";
			mesg="나이는 2015년 이전, 15세 이상이어야 합니다. ";
		};	
		System.out.println("controller result : "+ result);
		System.out.println("page : "+ page);
		model.addAttribute("userDTO", userDTO);
		model.addAttribute("mesg", mesg);
		return page;				
	}//end main

}

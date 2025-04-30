package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginDTO;
@RestController/////////////////////
public class TestController {
	@RequestMapping("/register")
	public LoginDTO register(LoginDTO  dto) { //json형태로 받음
		System.out.println("/register 요청 :"+ dto);		
	return dto;
	}//end main
}

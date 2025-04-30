package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.LoginDTO;
import com.example.service.GreetingService;

import jakarta.servlet.http.HttpSession;



@Controller
public class HelloController {
	@Autowired
	GreetingService service;
	
	@GetMapping("/login")	
	public String getLogin(LoginDTO dto) {
		System.out.println("/login get 요청 dto:"+ dto);		
	return "login";
	}//end main
	@PostMapping("/login")
	
	public String postLogin(LoginDTO dto) {
		System.out.println("/login post 요청 dto:"+ dto);		
		return "login";
	}//end main

	///////////////////////////////////////////////
	@RequestMapping("/list")
	public String getList(HttpSession session) {
		System.out.println("/login 요청 service:"+ service.getDto());
		LoginDTO dto= service.getDto();
		session.setAttribute("login", dto);
		System.out.println(session.getAttribute("login"));
	return "login";
	}//end main
	

	
	
	
	@RequestMapping("/main")
	public String main() {
		System.out.println("/main 요청");
		return "main";
	}//end main
	
	@GetMapping("/hello")
	public String hello(Model model) {
		System.out.println("/hello요청됨======");
		model.addAttribute("message", "test");	
		return "hello";
	}
}

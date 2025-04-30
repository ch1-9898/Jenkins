package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.LoginDTO;
import com.example.service.GreetingService;

import jakarta.servlet.http.HttpSession;



@Controller
public class HelloController {
	@Autowired
	GreetingService service;
	@GetMapping("/getDto")
	public String getDto(Model model) {
		System.out.println("/getDto요청됨======"+ service.getDto());
		model.addAttribute("dto", service.getDto().toString());	
		return "getDto";
	}
	
	
	@GetMapping("/hello")
	public String hello(Model model) {
		System.out.println("/hello요청됨======");
		model.addAttribute("message", "test");	
		return "hello";
	}
}

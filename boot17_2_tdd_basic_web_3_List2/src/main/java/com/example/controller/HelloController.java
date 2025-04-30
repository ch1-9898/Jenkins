package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.LoginDTO;
import com.example.service.GreetingService;



@Controller
public class HelloController {
	@Autowired
	GreetingService service;
	
	
	@RequestMapping("/list")
	public String getList(Model model) {
		System.out.println("/list 요청 service:"+ service.getList());
		List<LoginDTO> list= service.getList();
		model.addAttribute("list", list);		//String으로 비교하기 위해
//		model.addAttribute("list", list);		
		return "main";
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

package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginDTO;
import com.example.service.GreetingService;

import jakarta.servlet.http.HttpSession;



@Controller
//@RestController
public class HelloController {
	@Autowired
	GreetingService service;
	@GetMapping("/form")
	public String form() { //json형태로 받음
		
	return "form";
	}//end main
	

	
	
	


}

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
public class HelloController {
	@Autowired
	GreetingService service;
	@RequestMapping("/sessionTest")
	public String sessionTest(HttpSession session) { 
		System.out.println("/sessionTest : "+ session.getAttribute("login"));
		session.setAttribute("passwd", "1234");
	return "session";
	}//end main
	

	
	
	


}

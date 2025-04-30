package com.example.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	//intercepter 미적용
	@RequestMapping("/")
	public String main() {
		return "main";
	}

	//intercepter 미적용
	@RequestMapping("/zzz")
	public String zzz() {
		return "main";
	}

	@RequestMapping("/xyz")
	public String xyz() {
		return "main";
	}
	
	@RequestMapping("/cart")
	public void cart() {
	
	}
	@GetMapping("/login")
	public String loginForm() {
		
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(String userid, String password, HttpSession session) {
		session.setAttribute("userid", userid);
		return "main";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		System.out.println("/logout");
		session.invalidate();
		return "redirect:/login";
	}
}

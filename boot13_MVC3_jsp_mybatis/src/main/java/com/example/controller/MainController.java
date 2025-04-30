package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.Dept;
import com.example.service.DBService;

@Controller
public class MainController {
	@Autowired
	DBService service;
	
	
	@RequestMapping("/")
	public String main() {
		System.out.println("///////////////////////");
		return "main"; //main.jsp 
	}
	
	@RequestMapping("/list")
	public String list(Model m) {
		List<Dept> allData= service.list();
		System.out.println(allData);
		m.addAttribute("allData", allData);
		return "list"; //list.jsp 
	}
	
	@GetMapping("/deptDelete")
	public String deptDelete(int deptno) {
		System.out.println(deptno);
		return  "main";
	}

}

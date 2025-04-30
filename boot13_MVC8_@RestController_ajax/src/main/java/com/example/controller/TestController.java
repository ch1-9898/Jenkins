package com.example.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Login;

@RestController
public class TestController {

	
	@RequestMapping("/aaa")
	public Login aaa() {
		Login dto= new Login("aaaa", "1234");
		return dto;
	}
	
	@RequestMapping("/bbb")
	public ArrayList<Login> bbb() {
		Login dto = new Login("asdf", "1234");
		Login dto2 = new Login("eeee", "999");
		Login dto3 = new Login("gsfasf", "777");
		ArrayList<Login> list = new ArrayList<Login>();
		list.add(dto);
		list.add(dto2);
		list.add(dto3);
		return list;
	}
	
	@RequestMapping(value = "/ccc", produces = "text/plain;charset=UTF-8")
	public String ccc() {
		return "홍길동";
	}
	
	@RequestMapping(value = "/ddd", produces = "text/plain;charset=UTF-8")
	public String ddd() {
		String mesg = "<h1>Hello</h1>";
		return mesg;
	}
}

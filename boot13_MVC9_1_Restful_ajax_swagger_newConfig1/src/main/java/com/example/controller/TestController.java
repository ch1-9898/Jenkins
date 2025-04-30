package com.example.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Login;

@RestController
public class TestController {

	
	@RequestMapping(value ="/users/aaa", method = RequestMethod.GET)
	@CrossOrigin
	public String aaa() {
		System.out.println("/aaa get");
		return "get";
	}
	
	@RequestMapping(value ="/users/aaa", method = RequestMethod.POST)
	@CrossOrigin
	public String bbb() {
		System.out.println("/bbb post");
		return "post";
	}
	
	@RequestMapping(value ="/users/aaa", method = RequestMethod.PUT)
	@CrossOrigin
	public ArrayList<Login> ccc() {
		System.out.println("/users/ccc put");
		ArrayList<Login> list= new ArrayList<>();
		list.add(new Login("a","111"));
		list.add(new Login("b","222"));
		return list;
	}
	
	@RequestMapping(value ="/users/aaa", method = RequestMethod.DELETE)
	@CrossOrigin
	public Login ddd() {
		System.out.println("/ddd delete");
		return new Login("홍길동","1234");
	}
}

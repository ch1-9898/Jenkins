package com.example.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Login;

@RestController
public class TestController {

	
	@RequestMapping(value ="/aaa", method = RequestMethod.GET)
	@CrossOrigin
	public String aaa() {
		System.out.println("/aaa get");
		return "get";
	}
	
	@RequestMapping(value ="/aaa", method = RequestMethod.POST)
	@CrossOrigin
	public String bbb() {
		System.out.println("/bbb post");
		return "post";
	}
	
	@RequestMapping(value ="/aaa", method = RequestMethod.PUT)
	@CrossOrigin
	public String ccc() {
		System.out.println("/ccc put");
		return "put";
	}
	
	@RequestMapping(value ="/aaa", method = RequestMethod.DELETE)
	@CrossOrigin
	public String ddd() {
		System.out.println("/ddd delete");
		return "delete";
	}
}

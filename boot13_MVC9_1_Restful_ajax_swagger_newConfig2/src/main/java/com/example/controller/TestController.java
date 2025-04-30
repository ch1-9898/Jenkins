package com.example.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Login;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Test", description = "Test 관련 API 입니다")
public class TestController {

	@Operation(summary = "유저 정보 저장", description = "유저 정보를 저장합니다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "유저정보저장성공"),
			@ApiResponse(responseCode = "500", description = "유저정보저장실패(중복)")
			
	}
	)
	@RequestMapping(value ="/users/aaa", method = RequestMethod.GET)
	@CrossOrigin
	public String aaa() {
		System.out.println("/aaa get");
		return "get";
	}
	
	@Operation(summary = "유저 정보 반환", description = "전체 유저 정보를 반환합니다.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "유저정보반환성공"),
			@ApiResponse(responseCode = "500", description = "유저정보반환실패")
			
	}
	)
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

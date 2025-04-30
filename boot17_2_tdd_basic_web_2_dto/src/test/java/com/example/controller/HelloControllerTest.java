package com.example.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.dto.LoginDTO;
import com.example.service.GreetingService;


@AutoConfigureMockMvc
@SpringBootTest
public class HelloControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private GreetingService service;  //GreetingService의 명시적 빈 생성 및 컨테이너 등록

	@Test
	public void getDtoTest() throws Exception {
		LoginDTO mockDTO= new LoginDTO("홍길동", 20);
		
		mockMvc.perform(get("/getDto"))
		.andExpect(status().isOk())
		.andExpect(view().name("getDto"))
		.andExpect(model().attribute("dto", mockDTO.toString()));		
	}
	
	
	///////////////////////////////////
//	@Test
//	public void helloTest() throws Exception {
//		//System.out.println(service); //서비스 자동주입안됨
//		System.out.println(service.getDto());
//		mockMvc.perform(get("/hello"))
//		.andExpect(status().isOk())
//		.andExpect(view().name("hello"))
////		.andExpect(model().attribute("message", "aaa"));
//		.andExpect(model().attribute("message", "test"));
//		//.andDo(print());
//	}
	

}

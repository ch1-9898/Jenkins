package com.example.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.example.service.GreetingService;

import jakarta.servlet.http.HttpSession;


@AutoConfigureMockMvc
@SpringBootTest
public class HelloControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private GreetingService service;  //GreetingService의 명시적 빈 생성 및 컨테이너 등록
	
	@BeforeEach
	public void setUp() {
		System.out.println("setup실행됨 =======");
	}
	
	@Test
	public void registerTest() throws Exception {
		MultiValueMap<String, String> query_param = new LinkedMultiValueMap<>();
	    query_param.add("name","홍길동");
	    query_param.add("age","10");
		mockMvc.perform(
				post("/register").contentType(MediaType.APPLICATION_JSON)
				.params(query_param)				
				)//json 데이터 전송
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value("홍길동"))//응답처리
		.andExpect(jsonPath("$.age").value("10"));

	}
//	@Test
//	public void helloTest() throws Exception {
//		//System.out.println(service); //서비스 자동주입안됨
//		System.out.println(service.getDto());
//		mockMvc.perform(get("/hello"))
//		.andExpect(status().isOk())
//		.andExpect(view().name("hello"))
////		.andExpect(model().attribute("message", "aaa"));
//		.andExpect(model().attribute("message", "test"));
//	}
	
//	@Test 
//	public void loginTest() throws Exception{
//		//System.out.println("loginTest service: "+service.getDto());
//		
//		mockMvc.perform(get("/login"))
//		.andExpect(status().isOk())
//		.andExpect(view().name("login"));
//	//	MockHttpSession session = new MockHttpSession();
//		
//		//System.out.println("MockSession : " +session.getAttribute("login"));
//	}
}

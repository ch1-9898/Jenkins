package com.example.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.net.http.HttpResponse;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;

import com.example.dto.LoginDTO;
import com.example.service.GreetingService;

import ch.qos.logback.core.model.Model;
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
	public void listTest() throws Exception {
		//System.out.println(service); //서비스 자동주입안됨
		ResultActions resultActions =mockMvc.perform(get("/list")); 
		MvcResult mvcResult= resultActions.andExpect(status().isOk())
		.andDo(print()).andReturn(); //mvc Result 객체 얻기
		ModelAndView mv= mvcResult.getModelAndView();
		System.out.println("mv : "+ mv.getModel().get("list"));
//list내용비교
		
	
	}
	@Test
	public void helloTest() throws Exception {
		//System.out.println(service); //서비스 자동주입안됨
		System.out.println(service.getDto());
		mockMvc.perform(get("/hello"))
		.andExpect(status().isOk())
		.andExpect(view().name("hello"))
//		.andExpect(model().attribute("message", "aaa"));
		.andExpect(model().attribute("message", "test"));
	}
	
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

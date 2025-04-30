package com.example.controller;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.dto.User;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;


@Controller
public class MainController {
	@Autowired
	ServletContext application;
	
	//1. 기본
	@GetMapping("/")
	public String m() {
		return "main";   //  /resources/templates/main.html 
	}
	
	//2. 바인딩 - ${...}
	@GetMapping("/a2")
	public String a2(Model m ,HttpSession session,String userid) {
		System.out.println("a2 userid= "+ userid);
		m.addAttribute("username", "model홍길동"); //model scope없이 그냥 추출
		session.setAttribute("username","session홍길동");
		application.setAttribute("username", "application홍길동");
		return "main2";
	}
	
	
	
	
	
	
	
	//3. I18N..  #{....}
	@GetMapping("/a3")
	public String a3(Locale xxx) {
		System.out.println("current locale xxx: "+xxx);
		return "main3";
	}
	
	
	
	

	//4. 객체속성값 직접 접근 .. ,th:object=${객체키값},  *{속성명}  
	@GetMapping("/a4")
	public ModelAndView a4() {
		ModelAndView mav= new ModelAndView();
		mav.addObject("user", new User("홍길동", 20));
		mav.setViewName("main4");  //main4.html
		return mav;
	}
	
	@GetMapping("/a5")
	public String a5() {
		return "main5";
	}
	@GetMapping("/a55")
	public String a55(String username, int age) {
		System.out.println("/a55:"+username+"\t"+age);
		return "main5_1";
	}
	
	@GetMapping("/a6")
	public String a6(Model m) {
		m.addAttribute("user", new User("홍길동",20));
		return "main6";
	}
	
	@GetMapping("/a7")
	public String a7(Model m) {
		m.addAttribute("user", new User("홍길동",20));
		m.addAttribute("user2", new User("hong",20));
		List<User> list =
				Arrays.asList(new User("홍길동1",20),
						new User("홍길동2",30),
						new User("홍길동3",40)
						);
		m.addAttribute("userList",list);
		return "main7";
	}
	
	@GetMapping("/a8")
	public String a8(Model m) {
		m.addAttribute("user", new User("홍길동",20));
		m.addAttribute("imgWidth", 100);
		m.addAttribute("imgHeight", 200);
		m.addAttribute("xyz", "kkk2");
		
		return "main8";
	}
	
		
		
	@GetMapping("/a9")
	public String a9(Model m) {
		m.addAttribute("user", "홍길동");
	
		return "main9";
	}
		
		
		
		
		
		
		
		
		
}

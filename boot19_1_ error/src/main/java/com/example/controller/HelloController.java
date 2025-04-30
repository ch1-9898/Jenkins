package com.example.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.dto.UserDTO;



@Controller
public class HelloController {
	
	@GetMapping("/")
	public String main() {//////
		return "main";
	}//end main
	@GetMapping("/hello")
	public String hello() {//////
		return "hello";
	}//end main
	@GetMapping("/test")
	public String error() {//////500error
		int result=10/0;
		return "hello";
	}//end main
	
	@GetMapping("/test2")
	public void error2() throws Exception {//////500error throws
		//주소요청시 사용할 빈을 생성 후 jsp에 넘김
		throw new Exception("강제 에러 발생");
	}//end main
	@GetMapping("/test3")
	public void error3()  {////// 405d에러 
		//전송방식오류		
	}//end main
	

}

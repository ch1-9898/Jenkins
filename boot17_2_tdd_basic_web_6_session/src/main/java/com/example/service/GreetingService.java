package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.LoginDTO;

@Service
public class GreetingService {

	public GreetingService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMesg() {
		return "GreetingService.getMesg()";
	}
	public List<LoginDTO> getList(){
		List<LoginDTO> list= List.of(
				new LoginDTO("홍길동", 20),
				new LoginDTO("이순신", 10)
				);
		return list;
	}
	public LoginDTO getDto() {
		return new LoginDTO("홍길동", 20);
	}

}

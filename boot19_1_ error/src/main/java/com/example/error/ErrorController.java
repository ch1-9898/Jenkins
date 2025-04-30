package com.example.error;

import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice/////////////////////////////////////
//@RestController클래스 관련된 예외처리가 구현된 클래스를 나타내는 어노테이션
public class ErrorController  {
	public ErrorController() {
		System.out.println("ErrorController   생성됨");
	}
	@ExceptionHandler(NoHandlerFoundException.class)//404오류
    public String handleNotFoundError(NoHandlerFoundException ex, Model model) {
		System.out.println("404================");
        model.addAttribute("errorMessage", "요청하신 페이지를 찾을 수 없습니다.");
        return "error/error404"; // error404.jsp로 포워딩
    }
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public String HttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, Model model) {
		System.out.println("405================");
        model.addAttribute("errorMessage", "전송방식이 잘못되었습니다.");
        return "error/error405"; // error404.jsp로 포워딩
    }
	@ExceptionHandler(Exception.class)//500 
    public String ExceptionError(Exception ex, Model model) {
		System.out.println("Exception.class");
        model.addAttribute("errorMessage", "500 error");
        if(ex.getMessage()!=null) {
        	 model.addAttribute("errorMessage", ex.getMessage());
        }
        return "error/error500"; // error500.jsp로 포워딩
    }
	
//	@GetMapping("/error")//application.properties에서 설정됨
//	public String handleError(HttpServletRequest request) {
//		int statusCode= (int)request.getAttribute("jakarta.servlet.error.status_code");
//		System.out.println("ErrorController statusCode : "+ statusCode);
//		String page="";
//		if(statusCode==404) {
//			page="error404";
//		}
//		return page;
//	}
}

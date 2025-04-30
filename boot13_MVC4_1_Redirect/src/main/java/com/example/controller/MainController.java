package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dto.Login;

@Controller  // @RestController = @Controller + @ResponseBody
public class MainController {

	 @GetMapping("/form")
	    public String showForm() {
	        return "form"; // form.jsp로 이동
	    }

	    @PostMapping("/submit")
	    public String submitForm(RedirectAttributes redirectAttributes, Login dto) {
	    	System.out.println(dto);
	        redirectAttributes.addFlashAttribute("message", "전송 성공");
	        redirectAttributes.addFlashAttribute("login", dto);
	        return "redirect:/result";
	    }

	    @GetMapping("/result")
	    public String showResult(Model model) {
	        // addFlashAttribute로 전달한 값은 model에 자동으로 전달됨
	        return "result"; // result.jsp로 이동
	    }
	    @GetMapping("/test")
	    @ModelAttribute("login")
	    public Login test() {
	        // addFlashAttribute로 전달한 값은 model에 자동으로 전달됨
	    	
	        return new Login("abcde", "1234"); // result.jsp로 이동
	    }
}

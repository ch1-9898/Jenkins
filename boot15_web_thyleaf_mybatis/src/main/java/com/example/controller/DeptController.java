package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.dto.Dept;
import com.example.service.DBService;

@Controller
public class DeptController {
	@Autowired
	DBService service;	
	
	@RequestMapping("/list")
	public String getDeptList(Model m) {
		
		List<Dept> allData = service.list();
		System.out.println("list================="+ allData);
		m.addAttribute("allData", allData);			
		return "list"; //list.html
	}
	@RequestMapping("/insertForm")
	public String insertForm() {
		return "addForm"; //addForm.html
	}
	
	@RequestMapping("/insert")
	public String insert(Dept dept) {
		System.out.println("insert>>" + dept);
		service.insert(dept);
		return "redirect:list";
	}
	
	
	
	@RequestMapping("/deptUpdateForm")
	public ModelAndView updateForm(@RequestParam int deptno) {
		System.out.println("deptUpdateForm>>" + deptno);
		Dept dept= service.selectByDeptno(deptno);
		System.out.println(dept);
		ModelAndView mav= new ModelAndView();
		mav.addObject("dept", dept);
		mav.setViewName("update");//update.html		
		return mav;
	}
	
	
	
	
	
	@RequestMapping("/update")
	public String update(Dept dto) {
		System.out.println("deptUpdate>>" + dto);
		int n = service.update(dto);		
		return "redirect:list";
	}
	@RequestMapping("/deptDelete")
	public String delete(@RequestParam int deptno) {
		System.out.println("delete>>>>"+ deptno);
		int n = service.deleteByDeptno(deptno);	
		System.out.println(n);
		return "redirect:list";
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/deptRetrive")
	public String retrive(@RequestParam int deptno, Model m) {
		System.out.println("deptRetrive>>>>"+ deptno);
		Dept dept = service.selectByDeptno(deptno);	
		System.out.println(dept);
		m.addAttribute("dept", dept);
		return "retrive";//retrive.html 
	}
	
	
	
}

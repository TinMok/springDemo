package com.nufront.euht.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nufront.euht.service.api.Test2ServiceI;
import com.nufront.euht.service.api.TestServiceI;

@Controller
public class HelloController {

	@Autowired
	TestServiceI service;
	
	@Autowired
	Test2ServiceI service2;
	
	@RequestMapping("/test")
	public ModelAndView test() {
		String str = "Spring MVC示例";
		return new ModelAndView("home","str",str);
	}
	
	@RequestMapping("/test2")
	public ModelAndView test2() {
		ModelAndView modelAndView = new  ModelAndView("home");
		String str = "Spring MVC示例2";
		modelAndView.addObject("str", str);
		return modelAndView;
	}
	
	@RequestMapping("/test3")
	public String test3(HttpServletRequest request) {
		String str = "Spring MVC示例3";
		request.setAttribute("str", str);
		return "home";
	}
	
	@RequestMapping("/param")
	public String param(HttpServletRequest request, String name,
			@RequestParam("pass")String password) {
		System.out.println("name :" + name);
		System.out.println("password :" + password);
		String str = "Spring MVC传参";
		request.setAttribute("str", str);
		return "home";
	}
	
	@RequestMapping("/service")
	public String service(HttpServletRequest request, String name,
			@RequestParam("pass")String password) {
		String str = null;
		if (service.login(name, password)) {
			str = "登录成功";
		} else {
			str = "用户名或密码不正确";
		}
		request.setAttribute("str", str);
		return "home";
	}
	
	@RequestMapping("/service2")
		public String service2(HttpServletRequest request, String name,
			@RequestParam("pass")String password) {
		String str = service2.login(name, password);
		request.setAttribute("str", str);
		return "home";
	}
}

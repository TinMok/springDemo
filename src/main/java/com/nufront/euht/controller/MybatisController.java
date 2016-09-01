package com.nufront.euht.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nufront.euht.service.api.AccountServiceI;

@Controller
@RequestMapping("/mybatis")
public class MybatisController {

	@Autowired
	AccountServiceI accountService;
	
	/**
	 * 安装mysql数据库，并且插入数据
	 * 访问路径    localhost:8080/sample/mybatis/login.do?name=houzi&pass=123 
	 * */
	@RequestMapping("/login")
	public String login(HttpServletRequest request, String name,
			@RequestParam("pass")String password) {
		String str = null;
		if (accountService.login(name, password)) {
			str = "mybatis登录成功";
		} else {
			str = "mybatis用户名或密码不正确";
		}
		request.setAttribute("str", str);
		return "home";
	}
}

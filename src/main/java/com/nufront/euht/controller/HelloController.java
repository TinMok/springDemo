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

    /**
     * 访问路径 localhost:8080/sample/test.do 返回前端页面为 WEB-INF/content/home.jsp
     */
    @RequestMapping("/test")
    public ModelAndView test() {
        String str = "Spring MVC示例：返回数据给前端";
        return new ModelAndView("home", "str", str);
    }

    /**
     * 访问路径 localhost:8080/sample/test2.do
     */
    @RequestMapping("/test2")
    public ModelAndView test2() {
        ModelAndView modelAndView = new ModelAndView("home");
        String str = "Spring MVC示例2：返回数据给前端";
        modelAndView.addObject("str", str);
        return modelAndView;
    }

    /**
     * 访问路径 localhost:8080/sample/test3.do
     */
    @RequestMapping("/test3")
    public String test3(HttpServletRequest request) {
        String str = "Spring MVC示例3：返回数据给前端";
        ;
        request.setAttribute("str", str);
        return "home";
    }

    /**
     * 访问路径 localhost:8080/sample/param.do?name=houzi&pass=123
     */
    @RequestMapping("/param")
    public String param(HttpServletRequest request, String name, @RequestParam("pass") String password) {
        System.out.println("name :" + name);
        System.out.println("password :" + password);
        String str = "Spring MVC方法传参";
        request.setAttribute("str", str);
        return "home";
    }

    /**
     * 访问路径 localhost:8080/sample/param2.do?name=houzi&password=123
     */
    @RequestMapping("/param2")
    public String param2(HttpServletRequest request, User user) {
        System.out.println("name :" + user.getName());
        System.out.println("password :" + user.getPassword());
        String str = "Spring MVC方法传参：对象";
        request.setAttribute("str", str);
        return "home";
    }

    /**
     * 访问路径 localhost:8080/sample/param3.do?name=houzi&password=123
     */
    @RequestMapping("/param3")
    public String param3(HttpServletRequest request) {

        System.out.println("name :" + request.getParameter("name"));
        System.out.println("password :" + request.getParameter("password"));
        String str = "Spring MVC传参3 request.getParameter(String)";
        request.setAttribute("str", str);
        return "home";
    }

    public static class User {
        String name;
        String password;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    /**
     * 访问路径 localhost:8080/sample/service.do?name=houzi&password=123
     */
    @RequestMapping("/service")
    public String service(HttpServletRequest request, String name, String password) {
        String str = "最简单的Service";
        if (service.login(name, password)) {
            str = "service登录成功";
        } else {
            str = "service用户名或密码不正确";
        }
        request.setAttribute("str", str);
        return "home";
    }

    /**
     * 访问路径 localhost:8080/sample/service2.do?name=houzi&password=123
     */
    @RequestMapping("/service2")
    public String service2(HttpServletRequest request, User user) {
        String str = service2.login(user.getName(), user.getPassword());
        request.setAttribute("str", "Sping注入参数 <br/>" + str);
        return "home";
    }

}

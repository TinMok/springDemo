package com.nufront.euht.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nufront.euht.service.api.TestServiceI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
//@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestService {

	@Autowired
	TestServiceI service;
	
	@Test
	public void test(){
		if (service.login("houzi", "123") ) {
			System.out.println("登录成功");
		} else {
			System.out.println("登录失败");
		}
	}

}

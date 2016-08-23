package com.nufront.euht.service.impl;

import org.springframework.stereotype.Service;

import com.nufront.euht.service.api.TestServiceI;

@Service
public class TestService implements TestServiceI{

	@Override
	public boolean login(String name, String password) {
		if ("houzi".equals(name) && "123".equals(password))
			return true;
		return false;
	}
	
}

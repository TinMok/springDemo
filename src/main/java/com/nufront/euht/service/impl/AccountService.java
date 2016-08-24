package com.nufront.euht.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nufront.euht.dao.AccountMapper;
import com.nufront.euht.model.Account;
import com.nufront.euht.service.api.AccountServiceI;

@Service
public class AccountService implements AccountServiceI {

	@Autowired
	AccountMapper mapper;
	
	@Override
	public boolean login(String user, String password) {
		List<Account> accounts = mapper.getAll();
		for (Account account : accounts) {
			if(account.getUser().equals(user) && account.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

}

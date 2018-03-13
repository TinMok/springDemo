package com.nufront.euht.test;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.incrementer.OracleKeyGenerator;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.nufront.euht.model.Account;
import com.nufront.euht.service.api.IAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" , "classpath:spring-mybatis.xml"})
//@ContextConfiguration(locations = { "classpath:spring.xml"})
public class AccountServiceTest {

	@Autowired
	IAccountService service;
	
	@Before
	public void init() {
	    ArrayList<Account> list = new ArrayList<>();
	    for (int i = 0; i < 10; i++) {
            Account account = new Account();
            account.setUser("tuzi" + i);
            account.setPassword("123");
            list.add(account);
	    }
        service.insertBatch(list);
	}
	
	@After
	public void destory(){
	    service.delete(new EntityWrapper<Account>().like("user", "tuzi%"));
	}
	
	@Test
	public void test(){
	    Account account = new Account();
	    account.setUser("houzi1");
	    account.setPassword("123");
	    //account.insert();
	    System.out.println(account.getAccountId());
	    Page<Account> selectPage = service.selectPage(new Page<>(0, 5));
	    System.out.println(selectPage);
	}

}

package com.nufront.euht.service.impl;

import com.nufront.euht.service.api.Test2ServiceI;

public class Test2Service implements Test2ServiceI{

	String success;
	
	String fail;
	
	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getFail() {
		return fail;
	}

	public void setFail(String fail) {
		this.fail = fail;
	}

	@Override
	public String login(String name, String password) {
		if ("houzi".equals(name) && "123".equals(password))
			return success;
		return fail;
	}
	
}

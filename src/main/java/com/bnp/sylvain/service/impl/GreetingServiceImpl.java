package com.bnp.sylvain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.bnp.sylvain.dao.GreetingDAO;
import com.bnp.sylvain.model.Greeting;
import com.bnp.sylvain.service.GreetingService;

public class GreetingServiceImpl implements GreetingService{

	@Autowired
	GreetingDAO dao;
	
	@Override
	public Greeting getTheLastGreeting() {
		return dao.getGreeting();
	}

	@Override
	public Greeting getGrettingByDateAndCountry(String date, String country) {
		// TODO Auto-generated method stub
		return dao.getGreetingByDateAndCountry(date, country);
	}
	
}

package com.bnp.sylvain.dao;

import com.bnp.sylvain.model.Greeting;

public interface GreetingDAO {

	Greeting getGreeting();
	Greeting getGreetingByDateAndCountry(String year,String country);
	
}

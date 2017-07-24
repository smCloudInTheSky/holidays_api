package com.bnp.sylvain.service;

import com.bnp.sylvain.model.Greeting;

public interface GreetingService {
	Greeting getTheLastGreeting();
	Greeting getGrettingByDateAndCountry(String date, String country);
}

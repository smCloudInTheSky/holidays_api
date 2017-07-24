package com.bnp.sylvain.dao.impl;


import com.bnp.sylvain.dao.GreetingDAO;
import com.bnp.sylvain.model.Greeting;

public class GreetingDAOImpl implements GreetingDAO{

	@Override
	public Greeting getGreeting() {
		/* Tout le process pour lire à partir du fichier le Greeting */
		Greeting g = new Greeting();
		return g;
	}

	@Override
	public Greeting getGreetingByDateAndCountry(String date, String country) {
		Greeting g = new Greeting();
		g.setYear(date);
		g.setCountry(country);
		// TODO Auto-generated method stub
		return g;
	}

}

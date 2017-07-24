package com.bnp.sylvain.model;

import de.jollyday.HolidayCalendar;

public class Greeting {
    private String year; 
    private String country;
    public String getYear(){
    	return this.year;
    }
    
    public void setYear(String year){
    	this.year = year;
    }
    
    public String getCountry(){
		return this.country;
	}
	
	public void setCountry(HolidayCalendar country){
		this.country = country.toString();
	}
	
	public void setCountry(String country){
		this.country = country;
	}
}

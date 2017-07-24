package com.bnp.sylvain.model;

import de.jollyday.HolidayCalendar;
import java.util.Date;
import java.util.List;

public class Holidays {
	private HolidayCalendar country ;
	private List<HolidayCalendar> countrylist;
	private Date date;
	
	
	public Date getDate(){
		return this.date;
	}
	
	public void setDate(Date day){
		this.date = day;
	}
	
	public HolidayCalendar getCountry(){
		return this.country;
	}
	
	public void setCountry(HolidayCalendar country){
		this.country = country;
	}
	
	public void setCountry(String country){
		this.country = HolidayCalendar.valueOf(country);
	}
	
	public List<HolidayCalendar> getCountryList(){
		return this.countrylist;
	}
	
	public void setCountryList(List<HolidayCalendar> countrylist){
		this.countrylist = countrylist;
	}
	
	public String toString() {
        return "Holidays(Country: " + this.country + ", Countrylist: " + this.countrylist + "Day: "+this.date +")";
    }
}

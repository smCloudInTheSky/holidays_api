package com.bnp.sylvain.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bnp.sylvain.model.Greeting;

import de.jollyday.Holiday;
import de.jollyday.HolidayCalendar;
import de.jollyday.HolidayManager;

@Controller
public class GreetingController extends WebMvcConfigurerAdapter {
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/result").setViewName("result");
    }
	
	@GetMapping("/greeting")
	public String greetingForm(Model model) {
		model.addAttribute("greeting", new Greeting());
		return "greeting";
	}

	@PostMapping("/greeting")
	public String greetingSubmit(@Valid @ModelAttribute Greeting greeting, Model model, 
			BindingResult bindingresult) {
		if(bindingresult.hasErrors()){
			return "greeting";
		}
		else {
		HolidayManager target = HolidayManager.getInstance("target");
		Set<Holiday> targetdays = target.getHolidays(Integer.parseInt(greeting.getYear()));
		HolidayManager test = HolidayManager.getInstance(HolidayCalendar.valueOf(greeting.getCountry()).getId());
		Set<Holiday> fin = test.getHolidays(Integer.parseInt(greeting.getYear()));
		model.addAttribute("holidaylist", fin);
		model.addAttribute("target", targetdays);
		HolidayManager nyse = HolidayManager.getInstance(HolidayCalendar.NYSE);
		Set<Holiday> nysedays = nyse.getHolidays(Integer.parseInt(greeting.getYear()));
		model.addAttribute("nyse", nysedays);
		return "result";
		}
	}

	@ModelAttribute("countryList")
	public List<String> getCountryList() {
		List<String> countryList = new ArrayList<String>();
		HolidayCalendar[] listcountry = HolidayCalendar.values();
		for (int i = 0; i < listcountry.length; i++) {
			countryList.add(listcountry[i].toString());
		}
		return countryList;
	}
}

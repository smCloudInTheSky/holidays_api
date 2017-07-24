package com.bnp.sylvain.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bnp.sylvain.dao.GreetingDAO;
import com.bnp.sylvain.model.Greeting;

import de.jollyday.Holiday;
import de.jollyday.HolidayCalendar;
import de.jollyday.HolidayManager;

@Controller
public class GreetingController {
	
	GreetingDAO dao;
	
	@GetMapping("/greeting")
	public String greetingForm(Model model) {
		model.addAttribute("greeting", new Greeting());
		return "greeting";
	}

	@PostMapping("/greeting")
	public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
		// URL target = new
		// URL("gs-serving-web-content-complete/src/Holidays/Holidays_target.xml");
		HolidayManager target = HolidayManager.getInstance("target");
		Set<Holiday> targetdays = target.getHolidays(Integer.parseInt(greeting.getYear()));
		HolidayManager test = HolidayManager.getInstance(HolidayCalendar.valueOf(greeting.getCountry()).getId());
		Set<Holiday> fin = test.getHolidays(Integer.parseInt(greeting.getYear()));
		model.addAttribute("holidaylist", fin);
		model.addAttribute("target", targetdays);
		HolidayManager nyse = HolidayManager.getInstance(HolidayCalendar.NYSE);
		Set<Holiday> nysedays = nyse.getHolidays(Integer.parseInt(greeting.getYear()));
		model.addAttribute("nyse", nysedays);

		// GreetingService service = new GreetingServiceImpl();
		// Greeting g = service.getTheLastGreeting();
		// model.addAllAttributes(g.getMap());
		return "result";
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

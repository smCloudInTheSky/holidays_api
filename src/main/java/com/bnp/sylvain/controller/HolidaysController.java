package com.bnp.sylvain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.jollyday.HolidayManager;

import java.util.Calendar;
import java.time.ZoneId;

@Controller
public class HolidaysController {
	 
	 protected final HolidayManager test = HolidayManager.getInstance();
	 public final boolean holiday =  
			 /**
			  * test.isHoliday(LocalDate.now(),ZoneId.systemDefault().toString()); j'aimerais que ça marche mais rip ^^
			  *  
			  */test.isHoliday(Calendar.getInstance(),ZoneId.systemDefault().toString());
	 
	 
	 
	 @RequestMapping("/holidays")
	 public  String holidays(@RequestParam(value="isholi",required = false,defaultValue = "ceci est une erreur")String isholi,Model model){
		 if (holiday == true){
			 String lucky = "Today is a Holiday ";
			 model.addAttribute("isholi", lucky);
		 }
		 else {
			 String unlucky = "Today isn't a holiday ";
			 model.addAttribute("isholi", unlucky);
		 }
		 return "holidays";
	 }
	 
}

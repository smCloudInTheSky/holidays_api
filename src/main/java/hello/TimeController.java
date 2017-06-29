package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDateTime;


@Controller
public class TimeController {
	public final String day = LocalDateTime.now().toString();
	 @RequestMapping("/time")
	 public String time(@RequestParam(value="temps", required=false,defaultValue = "une valeur par défaut") String temps, Model model){
		 model.addAttribute("temps", day);
		 return "time";
	 }
}


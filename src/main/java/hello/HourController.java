package hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;

@Controller
public class HourController {
    public final String day = LocalDate.now().toString();
	 @RequestMapping("/hour")
	 public String hour(@RequestParam(value="date", required=false,defaultValue = "une valeur par défaut") String date, Model model){
		 model.addAttribute("date", day);
		 return "hour";
	 }
}

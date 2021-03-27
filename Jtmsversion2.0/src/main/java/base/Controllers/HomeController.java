package base.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
	
	
	@RequestMapping("/advertisement")
	public String advertisement() {
		return "advertisement";
	}
	
}

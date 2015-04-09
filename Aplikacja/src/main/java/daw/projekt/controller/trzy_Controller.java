package daw.projekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class trzy_Controller {
	
	@RequestMapping("/trzy")
	public String index(){
		return "trzy";
	}

}

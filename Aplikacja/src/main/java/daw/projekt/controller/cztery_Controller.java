package daw.projekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class cztery_Controller {
	
	@RequestMapping("/cztery")
	public String index(){
		return "cztery";
	}

}

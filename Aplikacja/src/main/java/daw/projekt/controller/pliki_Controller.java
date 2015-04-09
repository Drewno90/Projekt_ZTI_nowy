package daw.projekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pliki_Controller {
	
	@RequestMapping("/pliki")
	public String index(){
		return "pliki";
	}

}

package daw.projekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class kontakt_Controller {
	
	@RequestMapping("/kontakt")
	public String index(){
		return "kontakt";
	}

}

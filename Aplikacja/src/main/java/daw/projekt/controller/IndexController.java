package daw.projekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import daw.projekt.service.ItemService;

@Controller
public class IndexController {
	

	@RequestMapping("/index")
	public String index(){
		return "index";
	}

}

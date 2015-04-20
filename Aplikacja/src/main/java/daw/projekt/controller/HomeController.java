package daw.projekt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import daw.projekt.service.ItemService;

@Controller
public class HomeController {
	
	private ItemService itemService;
	
	@RequestMapping("/home")
	public String index(Model model){
		model.addAttribute("items", itemService.getItems());
		return "home";
	}
}

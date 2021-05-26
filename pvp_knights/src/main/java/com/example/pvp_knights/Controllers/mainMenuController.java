package com.example.pvp_knights.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class mainMenuController {

	@GetMapping("/")
	public String main_menu(Model model) {
		model.addAttribute("title", "PVP Knights");
		return "page";
	}
	
	
	
}

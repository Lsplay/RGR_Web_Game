package com.example.pvp_knights.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class startController {

	@GetMapping("/")
	public String start(Model model) {
		model.addAttribute("title", "Home");
		return "start";
	}
	
}

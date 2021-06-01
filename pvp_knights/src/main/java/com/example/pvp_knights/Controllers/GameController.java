package com.example.pvp_knights.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

	@GetMapping("/game")
	public String gameStart(Model model) {
		
		model.addAttribute("title", model);
		
		return "game";
	}
	
}

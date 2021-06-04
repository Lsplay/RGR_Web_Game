package com.example.pvp_knights.Controllers;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.pvp_knights.dataBase.data.user_information_service;
import com.example.pvp_knights.dataBase.models.user_information;
import com.example.pvp_knights.dataBase.repository.user_information_Repository;

import sun.text.normalizer.ICUBinary.Authenticate;

@Controller
public class GameController {
	
	@Autowired
	user_information_Repository userRepo;
	
	@Autowired
	user_information_service userService;
	
	
	
	@GetMapping("/game")
	public String gameStart(Principal prinсipal,Model model) {
		user_information user = (user_information) userService.loadUserByUsername(prinсipal.getName());
		user.setActive(true);
		userRepo.save(user);
		Iterable<user_information> players = userRepo.findByActiveTrue();
		model.addAttribute("user", players);
		return "game";
	}
	
	
}

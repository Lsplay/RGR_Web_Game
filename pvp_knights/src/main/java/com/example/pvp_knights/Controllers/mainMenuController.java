package com.example.pvp_knights.Controllers;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pvp_knights.dataBase.data.user_information_service;
import com.example.pvp_knights.dataBase.models.user_information;
import com.example.pvp_knights.dataBase.repository.user_information_Repository;

@Controller
public class mainMenuController {
	
	@Autowired
	user_information_service userService;
	
	@Autowired
	user_information_Repository userRepo;
	
	@GetMapping("/")
	public String main_menu(Principal printipal, Model model) {
		Iterable<user_information> rating=userRepo.findTop10ByOrderByRatingDesc();
		user_information user = (user_information) userService.loadUserByUsername(printipal.getName());
		user.setActive(false);
		userRepo.save(user);
		  model.addAttribute("user", user);
		  model.addAttribute("rating",rating);
		return "page";
	}
	
	
	@GetMapping("/profile")
	public String main_menu_profile(Principal printipal, Model model) {
		
		user_information user = (user_information) userService.loadUserByUsername(printipal.getName());
		  model.addAttribute("user", user);
		  
		return "profile";
	}
	
	
	
}

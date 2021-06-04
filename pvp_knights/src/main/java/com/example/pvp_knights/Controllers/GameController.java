package com.example.pvp_knights.Controllers;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String gameStart(Principal prinсipal, Model model) {
		user_information user = (user_information) userService.loadUserByUsername(prinсipal.getName());
		user.setActive(true);
		userRepo.save(user);
		Iterable<user_information> players = userRepo.findByActiveTrue();
		model.addAttribute("user", players);
		return "game";
	}

	@GetMapping("/game/fighpart")
	public String game(Principal prinсipal, Model model) {

		return "fightpage";
	}

	@PostMapping("/game/fighpart")
	public String takeAction(Principal principal, Model model,
			@RequestParam(value = "action", required = false) String action) {
		user_information user = (user_information) userService.loadUserByUsername(principal.getName());
		if (user.combo < 3) {
			if (action.equals("sword")) {
				if (user.isCombo2()) {
					model.addAttribute("third", "sword");
				}
				if (user.isCombo1()) {
					model.addAttribute("second", "sword");
				}
				if (user.isCombo0()) {
					model.addAttribute("first", "sword");
				}
			}
			if (action.equals("shild")) {
				if (user.isCombo2()) {
					model.addAttribute("third", "shild");
				}
				if (user.isCombo1()) {
					model.addAttribute("second", "shild");
				}
				if (user.isCombo0()) {
					model.addAttribute("first", "shild");
				}
			}
			if (action.equals("kick")) {
				if (user.isCombo2()) {
					model.addAttribute("third", "kick");
				}
				if (user.isCombo1()) {
					model.addAttribute("second", "kick");
				}
				if (user.isCombo0()) {
					model.addAttribute("first", "kick");
				}
			}
			user.combo++;
		}
		return null;
	}

}

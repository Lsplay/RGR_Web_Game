package com.example.pvp_knights.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pvp_knights.dataBase.data.user_information_service;

@Controller
public class AdminMenuController {

	@Autowired
	private user_information_service userService;

	@GetMapping("/admin")
	public String userList(Model model) {
		model.addAttribute("allUsers", userService.allUsers());
		return "admin";
	}

	@PostMapping("/admin")
	public String deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
			@RequestParam(required = true, defaultValue = "") String action, Model model) {

		if(action.equals("delete")) {
			userService.deleteUser(userId);
		}
		return "redirect:/admin";
	}
	
	@GetMapping("/admin/gt/{userId}")
	public String gtUser(@PathVariable("userId") Long userId, Model model) {
		model.addAttribute("allUsers", userService.usergtList(userId));
		return "admin";
	}
}

package com.example.pvp_knights.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.pvp_knights.dataBase.data.user_information_service;
import com.example.pvp_knights.dataBase.models.user_information;

@Controller
public class RegController {

	@Autowired
	private user_information_service userService;

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("userForm", new user_information());

		return "registration";
	}
	
	@GetMapping("/start")
	public String start(Model model) {
		model.addAttribute("userForm", new user_information());

		return "start";
	}

	@PostMapping("/registration")
	public String addUser(@ModelAttribute("userForm") user_information userForm, BindingResult bindingResult,
			Model model) {

		if (bindingResult.hasErrors()) {
			return "registration";
		}
		if (!userForm.getPassword().equals(userForm.getPasswordConfirm())) {
			model.addAttribute("passwordError", "Пароли не совпадают");
			return "registration";
		}
		if (!userService.saveUser(userForm)) {
			model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
			return "registration";
		}

		return "redirect:/";
	}

}

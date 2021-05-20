package com.example.pvp_knights.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pvp_knights.dataBase.models.user_information;
import com.example.pvp_knights.dataBase.repository.user_information_Repository;

@Controller
public class regAndAuntController {

	@Autowired
	private user_information_Repository UserRepository;
	
	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("title","Registration");
		return "registration";
	}
	
	@GetMapping("/auntification")
	public String auntification(Model model) {
		model.addAttribute("title","Auntification");
		return "auntification";
	}
	
	
	@PostMapping("/registration")
	public String regUser(@RequestParam String Loggin,@RequestParam String email, @RequestParam String password,@RequestParam String passwordConfirm,  Model model) {
		if(password!=passwordConfirm) {
			model.addAttribute("passwordError", "Пароли не совпадают");
			return "redirect:/";
		
		}
		user_information User_information = new user_information(Loggin, password, email);
		UserRepository.save(User_information);
	
		return "redirect:/";
	}
	
	@PostMapping("/auntification")
	public String auntUser(@RequestParam String Loggin, @RequestParam String password) {
		
		return "redirect:/";
	}
	
}

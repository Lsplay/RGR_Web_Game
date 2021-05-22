package com.example.pvp_knights.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public  String regUser(@RequestParam(name="name") String login,@RequestParam (name="email") String email, @RequestParam (name="pass") String password,@RequestParam (name="re_pass") String passwordConfirm,  Model 	model) {
		if(!password.equals(passwordConfirm)) {
			System.out.println(password);
			System.out.println(passwordConfirm);
			return "redirect:/registration";
		}
		user_information User_information = new user_information(login, password, email);
		UserRepository.save(User_information);
		return "redirect:/";
	}
	
	@PostMapping("/auntification")
	public String auntUser(@RequestParam(name="your_name") String Loggin, @RequestParam(name="your_pass") String password) {
		List<user_information> user=UserRepository.findByLogin(Loggin);
		
		System.out.println(user);
		System.out.println(UserRepository.findByLogin(Loggin));
		return "redirect:/";
	}
	
}

package com.example.pvp_knights.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pvp_knights.dataBase.data.user_information_service;
import com.example.pvp_knights.dataBase.models.user_information;

@Controller
public class AuthController {

	@Autowired 
	user_information_service userService;
	
	@RequestMapping("/login")
	public String getLogin(@RequestParam(value="error",required=false)String error,
						   @RequestParam(value="logout",required=false)String logout,
						   Model model) {
		model.addAttribute("error", error!=null);
		model.addAttribute("logout",logout!=null);
		
		
		return "login";
	}

	
}

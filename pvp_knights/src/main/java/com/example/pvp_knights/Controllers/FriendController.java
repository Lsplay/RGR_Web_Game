package com.example.pvp_knights.Controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pvp_knights.dataBase.data.FriendListService;
import com.example.pvp_knights.dataBase.data.user_information_service;
import com.example.pvp_knights.dataBase.models.FriendList;
import com.example.pvp_knights.dataBase.models.user_information;
import com.example.pvp_knights.dataBase.repository.user_information_Repository;

@Controller
public class FriendController {

	@Autowired
	FriendListService FriendService;
	
	@Autowired 
	user_information_service userService;
	
	@Autowired
	user_information_Repository userRepo;
	
	@GetMapping("/friend")
	public String checkUsers(Model model, Principal principal) {
		user_information user = (user_information) userService.loadUserByUsername(principal.getName());
		List<FriendList> flAdd= FriendService.findAllFriend(user.getIdUser());
		List<FriendList> flReq= FriendService.findAllRequest(user.getIdUser());
		model.addAttribute("friend", flAdd);
		model.addAttribute("req",flReq);
		model.addAttribute("user",user);
		return "friend";
	}
	
	@GetMapping("/friend/add")
	public String addFriendMenu(Model model, Principal principal) {
		
		return "friend";
	}
	
	@PostMapping("/friend/add")
	public String addFriend(Model model, Principal principal, @RequestParam String name) {
		user_information user = (user_information) userService.loadUserByUsername(principal.getName());
		
		if(!FriendService.sendFriend(user.getIdUser(), userService.loadUserByUsername(name).getIdUser())) {
			model.addAttribute("error", "Not found");
		}
		return "redirect:/friend";
	}
}

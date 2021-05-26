package com.example.pvp_knights.dataBase.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.stereotype.Service;

import com.example.pvp_knights.dataBase.repository.user_information_Repository;

@Service
public class user_infomrtion_service {

	@Autowired
	user_information_Repository User_Repo;
	
	
	
}

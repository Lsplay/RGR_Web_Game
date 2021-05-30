package com.example.pvp_knights.dataBase.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pvp_knights.dataBase.models.user_information;


@Repository
public interface user_information_Repository extends JpaRepository<user_information, Long> {

	user_information findByLogin(String Login);
	
	
	
}

package com.example.pvp_knights.dataBase.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pvp_knights.dataBase.models.user_information;

public interface user_information_Repository extends JpaRepository<user_information, Long> {

	
	
}

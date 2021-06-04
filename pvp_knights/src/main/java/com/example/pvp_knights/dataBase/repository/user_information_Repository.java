package com.example.pvp_knights.dataBase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.pvp_knights.dataBase.models.user_information;

@Repository
public interface user_information_Repository extends JpaRepository<user_information, Long> {

	user_information findByLogin(String Login);

	List<user_information> findByOrderByRatingDesc();

	Iterable<user_information> findTop10ByOrderByRatingDesc();

	user_information findByActivationCode(String code);

	Iterable<user_information> findByActiveTrue();
}

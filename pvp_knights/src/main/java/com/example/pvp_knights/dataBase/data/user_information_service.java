package com.example.pvp_knights.dataBase.data;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.pvp_knights.dataBase.models.Role;
import com.example.pvp_knights.dataBase.models.user_information;
import com.example.pvp_knights.dataBase.repository.RoleRepository;
import com.example.pvp_knights.dataBase.repository.user_information_Repository;

@Service
public class user_information_service implements UserDetailsService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	user_information_Repository userRepo;

	@Autowired
	RoleRepository roleRepo;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	//////////////////////////////////////////////////
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		user_information user = userRepo.findByLogin(username);

		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}

		return user;
	}

	public user_information findUserById(Long userId) {
		Optional<user_information> userFromDb = userRepo.findById(userId);
		return userFromDb.orElse(new user_information());
	}

	public List<user_information> allUsers() {
		return userRepo.findAll();
	}

	public boolean saveUser(user_information user) {
		user_information userFromDb = userRepo.findByLogin(user.getUsername());

		if (userFromDb != null) {
			return false;
		}

		user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepo.save(user);
		return true;
	}

	public boolean deleteUser(Long userId) {
		if (userRepo.findById(userId).isPresent()) {
			userRepo.deleteById(userId);
			return true;
		}
		return false;
	}

	public List<user_information> usergtList(Long idMin){
		return em.createQuery("SELECT u FROM user_information u WHERE u.id > :paramId",user_information.class).setParameter("paramId",idMin).getResultList();
	}

}

package com.example.pvp_knights.dataBase.data;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
	private MailSender mailSender;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	//////////////////////////////////////////////////
	@Override
	public user_information loadUserByUsername(String username) throws UsernameNotFoundException {

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
		int i=1000;
		user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActivationCode(UUID.randomUUID().toString());
		user.setRating(i);
		userRepo.save(user);

		if (user.getEmail() != null) {
			String subject = "Activation code";

			String message = String.format("Hello, %s! \n"
					+ "Welcome to PWPKnights. Please, visit next link to activate account : http://localhost:8080/activate/%s",
					user.getLogin(), user.getActivationCode());
			mailSender.send(user.getEmail(), subject, message);
		}

		return true;
	}

	public boolean deleteUser(Long userId) {
		if (userRepo.findById(userId).isPresent()) {
			userRepo.deleteById(userId);
			return true;
		}
		return false;
	}

	public List<user_information> usergtList(Long idMin) {
		return em.createQuery("SELECT u FROM user_information u WHERE u.id > :paramId", user_information.class)
				.setParameter("paramId", idMin).getResultList();
	}

///////
	public boolean activateUser(String code) {

		user_information user = userRepo.findByActivationCode(code);

		if (user == null) {
			return false;
		}

		user.setActivationCode(null);

		userRepo.save(user);

		return true;
	}
///
	public user_information getById(Long id) {
		Optional<user_information> userOptional = userRepo.findById(id);
		if (userOptional.isPresent()) {
			return userOptional.get();
		}
		return null;
	}
	
	
}

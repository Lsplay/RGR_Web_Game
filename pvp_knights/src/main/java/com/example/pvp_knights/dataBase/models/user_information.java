package com.example.pvp_knights.dataBase.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class user_information implements Serializable {

	private static final long serialVersionUID = 6216344084865363418L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private Long idUser;

	private String login, password, email, role;
	private int numberOfWin, numberOfAllGame;

	

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumberOfWin() {
		return numberOfWin;
	}

	public void setNumberOfWin(int numberOfWin) {
		this.numberOfWin = numberOfWin;
	}

	public int getNumberOfAllGame() {
		return numberOfAllGame;
	}

	public void setNumberOfAllGame(int numberOfAllGame) {
		this.numberOfAllGame = numberOfAllGame;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	///////////////////////////////////

	public user_information(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email=email;
		numberOfAllGame = 0;
		numberOfWin = 0;
		role="USER";
	}
	
	public user_information(){
		
	}

	///////////////////////////////////
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;

		if (obj == this)
			return true;

		if (!(obj instanceof user_information))
			return false;

		user_information user = (user_information) obj;

		if (user.hashCode() == this.hashCode())
			return true;

		return false;
	}

	////////////// Роли//////////////////

	public Set<Role> getUserRoles() {
		Set<Role> userRoles = new HashSet<>();

		if (role != null && role.length() > 0) {

			String[] rolesArr = role.split(",");
			for (String role : rolesArr) {
				userRoles.add(Role.valueOf(role));
			}
		}

		return userRoles;
	}

	public String getHighLevelRole() {

		List<String> allRoles = new ArrayList<>();

		for (Role role : this.getUserRoles()) {
			allRoles.add(role.toString());
		}

		if (allRoles.contains(Role.ADMIN.toString())) {
			return Role.ADMIN.toString();
		} else if (allRoles.contains(Role.MANAGER.toString())) {
			return Role.MANAGER.toString();
		} else {
			return Role.USER.toString();
		}

	}

	public List<String> getRolesList() {
		List<String> list = new ArrayList<>();

		this.getUserRoles().toArray();

		for (Role role : this.getUserRoles()) {
			list.add(role.toString());
		}

		return list;
	}

	public void addRole(Role role) {
		Set<Role> roleSet = this.getUserRoles();
		roleSet.add(role);

		this.role = convertRoleSetToString(roleSet);
	}

	public void removeRole(Role role) {
		Set<Role> roleSet = this.getUserRoles();
		roleSet.remove(role);

		this.role = convertRoleSetToString(roleSet);
	}

	private String convertRoleSetToString(Set<Role> roleSet) {
		List<String> roleArr = new ArrayList<>(roleSet.size());
		roleSet.forEach(c -> roleArr.add(c.toString()));

		return String.join(",", roleArr);
	}
	/////////////////Конец Ролей//////////////////////

}

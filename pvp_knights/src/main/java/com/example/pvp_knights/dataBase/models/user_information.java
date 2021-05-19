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
	private Long IdUser;

	private String Login, Password, Email, role;
	private int NumberOfWin, NumberOfAllGame;

	public Long getIdUser() {
		return IdUser;
	}

	public void setIdUser(Long user_id) {
		this.IdUser = user_id;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getNumberOfWin() {
		return NumberOfWin;
	}

	public void setNumberOfWin(int numberOfWin) {
		NumberOfWin = numberOfWin;
	}

	public int getNumberOfAllGame() {
		return NumberOfAllGame;
	}

	public void setNumberOfAllGame(int numberOfAllGame) {
		NumberOfAllGame = numberOfAllGame;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	///////////////////////////////////

	public user_information(String login, String password, String email) {
		Login = login;
		Password = password;
		email = Email;
		NumberOfAllGame = 0;
		NumberOfWin = 0;
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

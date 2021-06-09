package com.example.pvp_knights.dataBase.models;

import java.util.Collection;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;
import javax.swing.Spring;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class user_information implements UserDetails {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long idUser;

	private String login;
	private int rating;
	private String password;
	private String email;
	public String activationCode;
	private int numberOfWin, numberOfAllGame;
	public boolean active;
	public int combo;
	public boolean haveEnemy;

	@Transient
	private String passwordConfirm;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;
///////////////
 
	
	
	public Long getIdUser() {
		return idUser;
	}

	

	public boolean isHaveEnemy() {
		return haveEnemy;
	}



	public void setHaveEnemy(boolean haveEnemy) {
		this.haveEnemy = haveEnemy;
	}



	public int getCombo() {
		return combo;
	}

	public void setCombo(int combo) {
		this.combo = combo;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
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

	public String getActivationCode() {
		return activationCode;
	}

	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	///////////////////////////////////

	

	public user_information(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
		numberOfAllGame = 0;
		numberOfWin = 0;
		rating = 1000;
	}

	public user_information() {
		
	}

	public user_information(String login, String password) {
		this.login = login;
		this.password = password;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	///////////////// Конец Ролей//////////////////////
	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return getRoles();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	public boolean isCombo0() {
		if(combo==0) {
			return true;
		}
		return false;
	}
	public boolean isCombo1() {
		if(combo==1) {
			return true;
		}
		return false;
	}
	public boolean isCombo2() {
		if(combo==2) {
			return true;
		}
		return false;
	}

}

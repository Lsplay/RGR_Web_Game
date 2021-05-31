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



import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class user_information implements UserDetails {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long idUser;
	
	
	private String login;
	private float rating;
	private String password;
	private String email;
	private int numberOfWin, numberOfAllGame;

	@Transient
	private String passwordConfirm;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles;
///////////////
	
	
	public Long getIdUser() {
		return idUser;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		rating = rating;
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

	

	///////////////////////////////////

	public user_information(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
		numberOfAllGame = 0;
		numberOfWin = 0;
		rating=0;
	}

	public user_information() {

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

}

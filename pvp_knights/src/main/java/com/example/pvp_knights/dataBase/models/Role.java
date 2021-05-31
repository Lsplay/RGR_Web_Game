package com.example.pvp_knights.dataBase.models;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	@Transient
	@ManyToMany(mappedBy = "roles")
	private List<user_information> users;

	public Role() {
	}
	
	public Role(Long id) {
		this.id=id;
	}
	
	public Role(Long id, String name) {
		this.id=id;
		this.name=name;
	}
//////////////////////
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<user_information> getUsers() {
		return users;
	}

	public void setUsers(List<user_information> users) {
		this.users = users;
	}
///////////////////////////
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return getName();
	}
}
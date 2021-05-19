package com.example.pvp_knights.dataBase.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class user_list {

	
	@Id
	@Column(name="user_id")
	private Long id;

	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private user_information User;
	
	public user_list() {
	}
}

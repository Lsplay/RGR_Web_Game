package com.example.pvp_knights.dataBase.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class rating_information {

	@Id
	@Column(name="user_id")
	private Long user_id;
	
	private float Rating ;

	
	@OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private user_information user;
	
	

	public float getRating() {
		return Rating;
	}

	public void setRating(float rating) {
		Rating = rating;
	}

	
	
	public rating_information() {
		Rating=0;
		
	}
	
}

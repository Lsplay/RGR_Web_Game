package com.example.pvp_knights.dataBase.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class game_information {

	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long game_id;
	
	
	private float first_player_rating,second_player_rating;
	
	@OneToOne(fetch = FetchType.LAZY)
    private user_information user1_id;
	
	@OneToOne(fetch = FetchType.LAZY)
    private user_information user2_id;
	
	public Long getGame_id() {
		return game_id;
	}
	public void setGame_id(Long game_id) {
		this.game_id = game_id;
	}
	
	public float getFirst_player_rating() {
		return first_player_rating;
	}
	public void setFirst_player_rating(float first_player_rating) {
		this.first_player_rating = first_player_rating;
	}
	public float getSecond_player_rating() {
		return second_player_rating;
	}
	public void setSecond_player_rating(float second_player_rating) {
		this.second_player_rating = second_player_rating;
	}
	
	public game_information( float first_rating, float second_rating) {
		
		first_player_rating=first_rating;
		second_player_rating=second_rating;
	}
	
}

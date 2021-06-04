package com.example.pvp_knights.dataBase.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="friend_list")
public class FriendList {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
 	private Long user1Id;

 	private Long user2Id;

	@Column(name="friendship")
	private boolean friendship;
	
	public boolean isFriendship() {
		return friendship;
	}

	public void setFriendship(boolean friendship) {
		this.friendship = friendship;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Long getUser1() {
		return user1Id;
	}

	public void setUser1(Long user1) {
		this.user1Id = user1;
	}

	public Long getUser2() {
		return user2Id;
	}

	public void setUser2(Long user2) {
		this.user2Id = user2;
	}

	
	 @Override
	 public int hashCode() {
		 return Objects.hash(id, user1Id, user2Id);
	 }

	 @Override
	 public boolean equals(Object obj) {
	     if (obj == null)
	         return false;
	     if (obj == this)
	         return true;

	     if (!(obj instanceof FriendList))
	        return false;

	     FriendList friends = (FriendList)obj;

	     if (friends.hashCode() == this.hashCode())
	        return true;

	        return false;
	    }
}
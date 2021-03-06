package com.example.pvp_knights.dataBase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.pvp_knights.dataBase.models.FriendList;

@annotation.Benchmark
public interface FriendListRepository extends JpaRepository<FriendList, Long> {
	
	List<FriendList> findByUser1IdOrUser2Id(Long user1Id, Long user2Id);
	List<FriendList> findByUser1IdOrUser2IdAndFriendshipTrue(Long userId, Long userId2);
	FriendList findByUser1IdAndUser2IdAndFriendshipTrue(Long userId, Long userId2);
	List<FriendList> findByUser1IdOrUser2IdAndFriendshipFalse(Long userId, Long userId2);
	List<FriendList> findByUser1IdOrUser2IdAndFriendship(Long userId, Long userId2, boolean i);
	List<FriendList> findByUser1IdAndFriendshipFalseOrUser2IdAndFriendshipFalse(Long userId, Long userId2);
	List<FriendList> findByUser1IdAndFriendshipTrueOrUser2IdAndFriendshipTrue(Long userId, Long userId2);
	List<FriendList> findByUser2IdAndFriendshipFalse(Long userId);
	FriendList findByUser1IdAndUser2Id(Long id, Long id2);
}
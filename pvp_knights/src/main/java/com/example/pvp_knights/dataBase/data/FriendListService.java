package com.example.pvp_knights.dataBase.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pvp_knights.dataBase.models.FriendList;
import com.example.pvp_knights.dataBase.repository.FriendListRepository;

@Service
public class FriendListService {

	@Autowired
	FriendListRepository friendRepo;
	
	public List<FriendList> findAllFriend(Long id){
		List<FriendList> friends=null;
		if(friendRepo.findByUser1IdOrUser2IdAndFriendshipTrue(id, id)!=null) {
			friends.addAll(friendRepo.findByUser1IdOrUser2IdAndFriendshipTrue(id, id));
			return friends;
		}
		return null;
	}
	
	public List<FriendList> findAllRequest(Long id){
		List<FriendList> friends=null;
		if(friendRepo.findByUser1IdOrUser2IdAndFriendshipFalse(id, id)!=null) {
			friends.addAll(friendRepo.findByUser1IdOrUser2IdAndFriendshipFalse(id, id));
			return friends;
		}
		return null;
	}
	
	public boolean sendFriend(Long id1, Long id2) {
		if(friendRepo.findByUser1IdOrUser2Id(id1, id2)==null||friendRepo.findByUser1IdOrUser2Id(id2, id1)==null) {
			FriendList fl=null;
			fl.setUser1(id1);
			fl.setUser2(id2);
			fl.setFriendship(false);
			friendRepo.save(fl);
			return true;
		}
		return false;
	}
	
	public boolean takeRequest(Long id1,Long id2) {
		if(friendRepo.findByUser2IdAndFriendshipFalse(id2)!=null) {
			List<FriendList> fl = friendRepo.findByUser2IdAndFriendshipFalse(id2);
			for(int i=0;i<fl.size();i++) {
				if(fl.get(i).getUser1()==id1) {
					FriendList fls=fl.get(i);
					fls.setFriendship(true);
					return true;
				}
			}
		}
		return false;
	}
	
}

package com.takeaway.gameof3.api.repository;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;

import com.takeaway.gameof3.api.entity.Player;

@ApplicationScoped
public class PlayerRepository {
	private Set<Player> players = new HashSet<>();
	
	public void store(Player player){
		players.add(player);
	}
	
	public int getNextIndex(){
		return players.size() + 1;
	}
}

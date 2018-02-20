package com.takeaway.gameof3.api.service;

import java.util.HashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;

import com.takeaway.gameof3.api.entity.Player;

@ApplicationScoped
public class PlayerService {
	
	private static final String PLAYER_NAME_TEMPLATE = "player_";
	private Set<Player> players;
	
	public PlayerService(){
		players = new HashSet<Player>();
	}
	
	public Player createNewPlayer(){
		int index = players.size();
		Player player = new Player(PLAYER_NAME_TEMPLATE + (index+1));
		players.add(player);
		return player;
	}
}

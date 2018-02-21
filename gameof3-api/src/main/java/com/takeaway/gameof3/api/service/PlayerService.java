package com.takeaway.gameof3.api.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.takeaway.gameof3.api.entity.Player;
import com.takeaway.gameof3.api.repository.PlayerRepository;

@ApplicationScoped
public class PlayerService {
	private static final String PLAYER_NAME_TEMPLATE = "player_";
	
	@Inject
	private PlayerRepository repository;
	
	public Player createNewPlayer(){
		Player player = new Player(PLAYER_NAME_TEMPLATE + (repository.getNextIndex()));
		repository.store(player);
		return player;
	}
}

package com.takeaway.gameof3.api.resource;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.takeaway.gameof3.api.entity.Player;
import com.takeaway.gameof3.api.service.PlayerService;

@Path("player")
public class PlayerResource {
	
	@Inject
	private PlayerService playerService;
	
	@POST
	@Path("create")
	public Player createNewPlayer(){
		return playerService.createNewPlayer();
	}
}

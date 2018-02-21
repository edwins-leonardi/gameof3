package com.takeaway.gameof3.api.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.takeaway.gameof3.api.entity.Player;
import com.takeaway.gameof3.api.service.PlayerService;

@Path("player")
@Produces("application/json")
@Consumes("application/json")
public class PlayerResource {
	
	@Inject
	private PlayerService playerService;
	
	@POST
	public Player createNewPlayer(){
		return playerService.createNewPlayer();
	}
}

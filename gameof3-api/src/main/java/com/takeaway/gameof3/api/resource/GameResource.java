package com.takeaway.gameof3.api.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.takeaway.gameof3.api.entity.Player;
import com.takeaway.gameof3.api.service.PlayerService;

@Path("/game")
@Produces("application/json")
@Consumes("application/json")
public class GameResource {
	
	@Inject
	private PlayerService playerService;
	
	@GET
	public Player joinGame(Player player){
		return playerService.createNewPlayer();
	}
}

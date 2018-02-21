package com.takeaway.gameof3.api.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.takeaway.gameof3.api.entity.GameStep;
import com.takeaway.gameof3.api.entity.Player;
import com.takeaway.gameof3.api.entity.Result;
import com.takeaway.gameof3.api.service.GameService;

@Path("/game")
@Produces("application/json")
@Consumes("application/json")
public class GameResource {
	
	@Inject
	private GameService gameService;
	
	@POST
	public GameStep joinGame(Player player){
		return gameService.joinGame(player);
	}
	
	@PUT
	public Result getGameStatus(GameStep gameStep){
		return gameService.getGameStatus(gameStep.getPlayer(), gameStep.getCurrentStep());
	}
}

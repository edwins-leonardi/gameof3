package com.takeaway.gameof3.client.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.takeaway.gameof3.client.entity.GameStep;
import com.takeaway.gameof3.client.entity.Player;
import com.takeaway.gameof3.client.entity.Result;
import com.takeaway.gameof3.client.game.client.GameApiClient;
import com.takeaway.gameof3.client.service.GameService;

@Path("/player")
@Produces("application/json")
@Consumes("application/json")
public class PlayerResource {
	
	@Inject
	private GameService gameService;
	@Inject
	private GameApiClient gameApiClient;
	
	@GET
	@Path("/play")
	public GameStep joinGame(){
		Player player = gameApiClient.joinGame(); 
		return new GameStep(player);
	}
	
	@POST
	@Path("/check")
	public Result checkGame(GameStep gameStep){
		return gameService.checkGameStatus(gameStep.getPlayer(), gameStep.getCurrentStep());
	}

	@POST
	@Path("/play-again")
	public GameStep playAgain(Player player){
		return gameService.playAgain(player);
	}

}

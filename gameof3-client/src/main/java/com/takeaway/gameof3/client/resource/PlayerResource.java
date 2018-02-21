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

@Path("/player")
@Produces("application/json")
@Consumes("application/json")
public class PlayerResource {
	
	@Inject
	private GameApiClient gameApiClient;
	
	@GET
	@Path("/play")
	public GameStep joinGame(){
		Player player = gameApiClient.createPlayer(); 
		return gameApiClient.joinNewGame(player);
	}
	
	@POST
	@Path("/check")
	public Result checkGame(GameStep gameStep){
		return gameApiClient.getGameStatus(gameStep);
	}

	@POST
	@Path("/play-again")
	public GameStep playAgain(Player player){
		return gameApiClient.joinNewGame(player);
	}
}

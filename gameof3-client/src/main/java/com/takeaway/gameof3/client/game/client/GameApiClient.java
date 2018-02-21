package com.takeaway.gameof3.client.game.client;

import com.takeaway.gameof3.client.entity.GameStep;
import com.takeaway.gameof3.client.entity.Player;
import com.takeaway.gameof3.client.entity.Result;

import feign.Feign;
import feign.Headers;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

@Headers("Content-Type: application/json")
public interface GameApiClient {
	@RequestLine("POST /api/player")
	public Player createPlayer();

	@RequestLine("POST /api/game")
	public GameStep joinNewGame(Player player);

	@RequestLine("PUT /api/game")
	public Result getGameStatus(GameStep gameStep);

	static GameApiClient connect(String url){
		
		return Feign.builder().encoder(new GsonEncoder()).decoder(new GsonDecoder()).target(GameApiClient.class, url);
	}
}

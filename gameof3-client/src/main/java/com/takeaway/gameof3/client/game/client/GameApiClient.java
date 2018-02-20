package com.takeaway.gameof3.client.game.client;

import com.takeaway.gameof3.client.entity.Player;

import feign.Feign;
import feign.Headers;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;

@Headers("Content-Type: application/json")
public interface GameApiClient {
	@RequestLine("GET /api/game")
	public Player joinGame();
	 
	static GameApiClient connect(String url){
		
		return Feign.builder().encoder(new GsonEncoder()).decoder(new GsonDecoder()).target(GameApiClient.class, url);
	}
}

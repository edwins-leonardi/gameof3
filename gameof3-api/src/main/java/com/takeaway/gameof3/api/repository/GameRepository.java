package com.takeaway.gameof3.api.repository;

import java.util.HashMap;

import com.takeaway.gameof3.api.entity.Game;

public class GameRepository {
	private HashMap<String, Game> games = new HashMap<String, Game>();
	
	public void storeGame(String playerName, Game game){
		games.put(playerName, game);
	}
	
	public Game getGameByPlayerName(String playerName){
		return games.get(playerName);
	}
}

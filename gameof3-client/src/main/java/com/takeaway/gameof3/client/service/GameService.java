package com.takeaway.gameof3.client.service;

import java.util.HashMap;

import javax.enterprise.context.ApplicationScoped;

import com.takeaway.gameof3.client.entity.Game;
import com.takeaway.gameof3.client.entity.GameStep;
import com.takeaway.gameof3.client.entity.Player;
import com.takeaway.gameof3.client.entity.Result;

@ApplicationScoped
public class GameService {
	
	private Game gameToStart;
	private HashMap<String, Game> games = new HashMap<String, Game>();
	private static final String OUTPUT_FORMAT = "%s has added %s and returned %s"; 
	
	
	public GameStep playAgain(Player player) {
		if(gameToStart == null) 
			gameToStart = new Game(player.getName());
		else
			gameToStart.setPlayer2(player.getName());
		games.put(player.getName(), gameToStart);
		return new GameStep(player);
	}
	
	public Result checkGameStatus(Player player, Integer playerCurrentStep){
		if(games.containsKey(player.getName())) {
			Game game = games.get(player.getName());
			if(!playerCurrentStep.equals(game.getLastStep())){
				return new Result(game);
			}
			nextMove(game, player.getName());
		} else {
			if(gameToStart == null)
				gameToStart = new Game(player.getName());
			else{ 
				Game gameCopy = gameToStart;
				gameToStart.setPlayer2(player.getName());
				games.put(player.getName(), gameToStart);
				gameToStart = null;
				return new Result(gameCopy);
			}

			games.put(player.getName(), gameToStart);
				
		}
		return new Result(games.get(player.getName()));
	}
	
	private void nextMove(Game game, String playerName){
		if(!game.getLastPlayer().equals(playerName)){
			int currentNumber = game.getCurrentNumber();
			int nextNumber = calculateNumberDivisibleByThree(currentNumber);
			game.update(playerName, nextNumber);
			game.setLastPlayer(playerName);
			game.setStatus(String.format(OUTPUT_FORMAT, playerName, divisibleByThree(currentNumber), nextNumber));
			if(nextNumber == 1) {
				game.setStatus(game.getStatus() + ". " + playerName + " WINS!");
				game.finishGame();
			}
		}
	}
	
	private int calculateNumberDivisibleByThree(int currentNumber){
		int diff = divisibleByThree(currentNumber);
		return (currentNumber + diff) / 3;
	}
	
	private int divisibleByThree(int currentNumber){
		if(currentNumber % 3 == 0)
			return 0;
		else if((currentNumber + 1) % 3 == 0)
			return 1;
		else
			return -1;
	}
}

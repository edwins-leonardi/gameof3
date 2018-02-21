package com.takeaway.gameof3.api.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.takeaway.gameof3.api.entity.Game;
import com.takeaway.gameof3.api.entity.GameStep;
import com.takeaway.gameof3.api.entity.Player;
import com.takeaway.gameof3.api.entity.Result;
import com.takeaway.gameof3.api.repository.GameRepository;

@ApplicationScoped
public class GameService {
	private Game gameWithOnePlayer;
	private static final String OUTPUT_FORMAT = "%s has added %s and returned %s"; 
	
	@Inject
	private GameRepository repository;
	
	public GameStep joinGame(Player player) {
		if(gameWithOnePlayer == null)
			joinGameAsPrimaryPlayer(player);
		else 
			joinGameAsSecondPlayer(player);

		return new GameStep(player);
	}
	
	public Result getGameStatus(Player player, Integer playerCurrentStep){
		Game game = repository.getGameByPlayerName(player.getName());
		if(game != null) {
			if(!playerCurrentStep.equals(game.getLastStep())){
				return new Result(game);
			}
			nextMove(game, player.getName());
		} 
		return new Result(game);
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

	private void joinGameAsPrimaryPlayer(Player player1){
		gameWithOnePlayer = new Game(player1.getName());
		repository.storeGame(player1.getName(), gameWithOnePlayer);
	}

	private void joinGameAsSecondPlayer(Player player2){
		Game game = gameWithOnePlayer;
		game.setPlayer2(player2.getName());
		repository.storeGame(player2.getName(), game);
		gameWithOnePlayer = null;
	}
}

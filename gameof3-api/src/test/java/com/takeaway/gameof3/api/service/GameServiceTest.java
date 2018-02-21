package com.takeaway.gameof3.api.service;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.takeaway.gameof3.api.entity.Game;
import com.takeaway.gameof3.api.entity.Player;
import com.takeaway.gameof3.api.entity.Result;
import com.takeaway.gameof3.api.repository.GameRepository;

public class GameServiceTest {
	
	@InjectMocks
	private GameService service;
	@Mock
	private GameRepository repository;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void joinGame() {
		Player player1 = mockPlayer();
		service.joinGame(player1);	
		Mockito.verify(repository).storeGame(Mockito.anyString(), Mockito.any());
	}
	
	@Test
	public void getGameStatus() {
		Player player1 = mockPlayer();
		Game game = mockGame();
		Mockito.when(repository.getGameByPlayerName("Moby")).thenReturn(game);
		
		Result result = service.getGameStatus(player1, 1);
		
		assertThat(result.getCurrentStep(), equalTo(2));
		assertThat(result.getStatus(), equalTo("Holy joined. First number is 67"));
		assertThat(result.getFinished(), equalTo(false));
	}
	
	private Player mockPlayer(){
		return new Player("Moby");
	}

	private Game mockGame(){
		Game game = new Game("Moby");
		game.setCurrentNumber(67);
		game.setLastPlayer("Holy");
		game.setPlayer1("Moby");
		game.setPlayer2("Holy");
		game.setCurrentNumber(1);
		return game;
	}

}	

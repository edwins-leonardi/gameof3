package com.takeaway.gameof3.client.game.client;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class GameApiClientProducer {
	@Produces
	@ApplicationScoped
	public GameApiClient create(){
		return GameApiClient.connect("http://localhost:8081/");
	}
}

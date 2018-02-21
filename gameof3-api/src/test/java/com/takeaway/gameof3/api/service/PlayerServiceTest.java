package com.takeaway.gameof3.api.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.takeaway.gameof3.api.repository.PlayerRepository;

public class PlayerServiceTest {
	
	@InjectMocks
	private PlayerService service;
	@Mock
	private PlayerRepository repository;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createNewPlayer(){
		service.createNewPlayer();
		
		Mockito.verify(repository).store(Mockito.any());
	}
}

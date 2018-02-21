package com.takeaway.gameof3.api.entity;

import java.util.Random;

public class Game {
	private String player1;
	private String player2;
	private Integer currentNumber;
	private String status;
	private String lastPlayer;
	private Integer lastStep;
	private boolean finished;
	
	public Game(String player1){
		this.player1 = player1;
		this.currentNumber = new Random().nextInt(151) + 50;
		this.status = player1 + " started a new game. Waiting for one opponent now!";
		this.lastPlayer = player1;
		this.lastStep = 1;
	}
	
	public Integer getCurrentNumber() {
		return currentNumber;
	}
	public void setCurrentNumber(Integer currentNumber) {
		this.currentNumber = currentNumber;
	}
	public String getPlayer1() {
		return player1;
	}

	public void setPlayer1(String player1) {
		this.player1 = player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public void setPlayer2(String player2) {
		this.status = player2 + " joined. First number is " + currentNumber;
		this.lastStep++;
		this.player2 = player2;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastPlayer() {
		return lastPlayer;
	}

	public void setLastPlayer(String lastPlayer) {
		this.lastPlayer = lastPlayer;
	}
	
	public Integer getLastStep(){
		return lastStep;
	}
	
	public void update(String lastPlayer, Integer currentNumber){
		this.lastPlayer = lastPlayer;
		this.currentNumber = currentNumber;
		this.lastStep++;
	}
	
	public void finishGame(){
		this.finished = true;
	}

	public boolean isFinished() {
		return finished;
	}
}

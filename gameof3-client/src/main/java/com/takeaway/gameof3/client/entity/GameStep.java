package com.takeaway.gameof3.client.entity;

public class GameStep {
	private Player player;
	private Integer currentStep;
	
	public GameStep(Player player) {
		this.player = player;
		this.currentStep = 1;
	}
	
	public GameStep() {
	}

	public Integer getCurrentStep() {
		return currentStep;
	}
	public void setCurrentStep(Integer currentStep) {
		this.currentStep = currentStep;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
}	

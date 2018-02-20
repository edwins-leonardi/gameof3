package com.takeaway.gameof3.client.entity;

public class Result {
	private String status;
	private Integer currentStep;
	private Boolean finished;
	
	public Result(){
		
	}

	public Result(Game game) {
		super();
		this.status = game.getStatus();
		this.currentStep = game.getLastStep();
		this.finished = game.isFinished();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCurrentStep() {
		return currentStep;
	}

	public void setCurrentStep(Integer currentStep) {
		this.currentStep = currentStep;
	}

	public Boolean getFinished() {
		return finished;
	}

	public void setFinished(Boolean finished) {
		this.finished = finished;
	}
}

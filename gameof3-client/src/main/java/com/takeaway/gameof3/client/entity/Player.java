package com.takeaway.gameof3.client.entity;

public class Player {
	private String name;
	
	public Player(String name) {
		super();
		this.name = name;
	}

	public Player() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

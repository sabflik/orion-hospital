package com.company.models;

public class Patient {
	
	private int id;
	private String name;
	private String dob;
	private int gender;
	private int currentWard;
	public int getCurrentWard() {
		return currentWard;
	}

	public void setCurrentWard(int currentWard) {
		this.currentWard = currentWard;
	}

	public int getWaitingWard() {
		return waitingWard;
	}

	public void setWaitingWard(int waitingWard) {
		this.waitingWard = waitingWard;
	}

	private int waitingWard;

	Patient(int id, String name, String dob, int gender) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
	}
	
	int getId() {
		return id;
	}
	
	String getName() {
		return name;
	}
	
	String getDob() {
		return dob;
	}
	
	int getGender() {
		return gender;
	}
}

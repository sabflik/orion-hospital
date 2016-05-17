package com.company.models;

public class Patient {
	
	private int id;
	private String name;
	private String dob;
	private int gender;
	private int currentWard;
	private int waitingWard;

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
	
	public Patient() {
		
	}

	public Patient(int id, String name, String dob, int gender) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.gender = gender;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDob() {
		return dob;
	}
	
	public int getGender() {
		return gender;
	}
}

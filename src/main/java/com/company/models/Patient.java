package com.company.models;

public class Patient {
	
	private int id;
	private String name;
	private String dob;
	private int gender;
	
	public Patient(){
		
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setGender(int gender) {
		this.gender = gender;
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

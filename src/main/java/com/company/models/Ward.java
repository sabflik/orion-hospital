package com.company.models;

public class Ward {
	
	private int id;
	private String name;
	private int capacity;

	Ward(int id, String name, int capacity) {
		this.id = id;
		this.name = name;
		this.capacity = capacity;
	}
	
	int getId() {
		return id;
	}
	
	String getName() {
		return name;
	}
	
	int getcapacity() {
		return capacity;
	}
	
}

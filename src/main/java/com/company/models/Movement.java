package com.company.models;

public class Movement {
	
	private int event_index;
	private int id;
	private String from_ward;
	private String to_ward;
	private String date;
	
	public int getEvent_index() {
		return event_index;
	}

	public void setEvent_index(int event_index) {
		this.event_index = event_index;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFrom_ward(String from_ward) {
		this.from_ward = from_ward;
	}

	public void setTo_ward(String to_ward) {
		this.to_ward = to_ward;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	
	public Movement(){
		
	}

	public Movement(int event_index, int id, String from_ward, String to_ward, String date) {
		this.event_index = event_index;
		this.id = id;
		this.from_ward = from_ward;
		this.to_ward = to_ward;
		this.date = date;
	}
	
	public int getEventIndex() {
		return event_index;
	}
	
	public int getId() {
		return id;
	}
	
	public String getFrom_ward() {
		return from_ward;
	}
	
	public String getTo_ward() {
		return to_ward;
	}
	
	public String getDate() {
		return date;
	}
}

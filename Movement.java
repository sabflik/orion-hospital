public class Movement {
	
	private int event_index;
	private int id;
	private String from_ward;
	private String to_ward;
	private String date;

	Movement(int event_index, int id, String from_ward, String to_ward, String date) {
		this.event_index = event_index;
		this.id = id;
		this.from_ward = from_ward;
		this.to_ward = to_ward;
		this.date = date;
	}
	
	int getEventIndex() {
		return event_index;
	}
	
	int getId() {
		return id;
	}
	
	String getFrom_ward() {
		return from_ward;
	}
	
	String getTo_ward() {
		return to_ward;
	}
	
	String getDate() {
		return date;
	}
}

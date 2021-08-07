
public class CCA {
	
	private int ID;
	private String title;
	private String description;
	private int classSize;
	private String day;
	private String time;
	private String venue;
	private String instructor;
	
	public CCA(int ID, String title, String description, int classSize, String day, String time, String venue, String instructor) {
		super();
		this.ID = ID;
		this.title = title;
		this.description = description;
		this.classSize = classSize;
		this.day = day;
		this.time = time;
		this.venue = venue;
		this.instructor = instructor;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getClassSize() {
		return classSize;
	}

	public void setClassSize(int classSize) {
		this.classSize = classSize;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	public void displayCCA() {
		String output = String.format("%-5s %-25s %-25s %-15s %-20s %-10s %-25s %-20s\n", ID, title, instructor, classSize, day, time, venue, description);
		System.out.println(output);
	}

}


public class Database {
	
	private String studentID;
	private String studentName;
	
	public Database(String studentID, String studentName) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
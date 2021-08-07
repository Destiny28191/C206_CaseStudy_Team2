
public class Parent {
	
	private String specialID;
	private String studentID;
	private String choosenCCAID;
	private String choosenCCAName;
	
	public Parent(String specialID, String studentID, String choosenCCAID, String choosenCCAName) {
		super();
		this.specialID = specialID;
		this.studentID = studentID;
		this.choosenCCAID = choosenCCAID;
		this.choosenCCAName = choosenCCAName;
	}

	public String getSpecialID() {
		return specialID;
	}

	public void setSpecialID(String specialID) {
		this.specialID = specialID;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getChoosenCCAID() {
		return choosenCCAID;
	}

	public void setChoosenCCAID(String choosenCCAID) {
		this.choosenCCAID = choosenCCAID;
	}

	public String getChoosenCCAName() {
		return choosenCCAName;
	}

	public void setChoosenCCAName(String choosenCCAName) {
		this.choosenCCAName = choosenCCAName;
	}


	
	

}

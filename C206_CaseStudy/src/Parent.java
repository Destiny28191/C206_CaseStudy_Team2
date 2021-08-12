import java.util.ArrayList;

public class Parent {
	
	private String specialID;
	private String studentID;
	private String name;
	private String email;
	private String phoneNumber;
	private String choosenCCAID;
	private String choosenCCAName;
	
	public Parent(String specialID, String studentID, String name, String email, String phoneNumber,
			String choosenCCAID, String choosenCCAName) {
		super();
		this.specialID = specialID;
		this.studentID = studentID;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public static boolean add(ArrayList<Parent> parentList, Parent parent1) {
		parentList.add(parent1);
	    return true;
		
	}

}

public class Parent {
	
	private String specialID;
	private String phoneNumber;
	private String choosenCCAID;
	private String choosenCCAName;
	
	public Parent(String specialID, String phoneNumber, String choosenCCAID, String choosenCCAName) {
		super();
		this.specialID = specialID;
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


	
	

}

import java.util.ArrayList;

public class Parent {
	
	private String specialID;
	private String phoneNumber;
	private String studentID;
	private String choosenCCAID;
	private String choosenCCAName;


	public Parent(String specialID, String phoneNumber, String studentID, String choosenCCAID, String choosenCCAName) {
		super();
		this.specialID = specialID;
		this.phoneNumber = phoneNumber;
		this.studentID = studentID;
		this.choosenCCAID = choosenCCAID;
		this.choosenCCAName = choosenCCAName;
	}



	public static boolean add(ArrayList<Parent> parentList, Parent parent1) {
		parentList.add(parent1);
	    return true;
		
	}


	
	

}

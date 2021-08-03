import java.util.ArrayList;

public class C206_CaseStudy {

	private static final int OPTION_QUIT = 5;
	public static void main(String[] args) {

		ArrayList<Student> StudentList = new ArrayList<Student>();
		ArrayList<Parent> ParentList = new ArrayList<Parent>();
		ArrayList<Staff> StaffList = new ArrayList<Staff>();
		ArrayList<CCA> CCAList = new ArrayList<CCA>();

		StudentList.add(new Student("123", "pass123", "John Doe", "Primary 6",
				"6-B", "Desmond Lee", "Jane Doe", "JaneDoe@gmail.com",
				"9876543"));
		ParentList.add(new Parent("specialID123", "", ""));
		StaffList.add(new Staff("staffID123", "pass123"));
		CCAList.add(new CCA("Soccer", "It's a sport where you kick balls into nets", 25, "Wednesday", "2:30", "Field", "David Tan"));
		CCAList.add(new CCA("Basketball", "It's a sport where you throw balls into hoops", 30, "Friday", "2:30", "Basketball court", "Jack Johnson"));
		CCAList.add(new CCA("Concert Band", "It's a CCA where people play musical instruments", 60, "Tuesday and Friday", "3:30", "Room D-4", "Alvin Tay"));
		CCAList.add(new CCA("Going home club", "It's not a CCA, you just go home", 1, "Everyday", "Depends", "School Gate", "Yourself"));

		int option = 0;
		String user;

		//NOTE
		//Needs a login function because
		//This whole thing needs a boolean function depending on who logged in, where if String user; is "Staff", it shows options and functions meant for staff only
		//and if String user; is "User", it shows options and functions meant for user
		//It can either be put in else if (option == 2 && user == "Staff") {activate function meant for staff}
		//Or it can be if else inside the options
		
		while (option != OPTION_QUIT) {
			

			
			//change to SchoolCCARegistrationSystemMain.UserMenu(); to see what parent and students see
			
			//if(user == "user"){
			//   SchoolCCARegistrationSystemMain.UserMenu();
		    //}else{
			C206_CaseStudy.StaffMenu();
			//}
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				// View all CCA
			
				

			} else if (option == 2) {
				//Staff - Add a new item
				//User - combine view all items and add a function to select a CCA and add it to parentList
				
				

			} else if (option == 3) {
				// Update CCA
				//After clicking 3, the system displays different things depending on who's logged in
				
				//Staff - Show list of all CCA and prompt the staff to enter the ID of the CCA they want to update
				//then it prompts the user to choose which detail they want to update, there's title, description, classSize, day, time, venue, instructor
				//Use get method when they select a CCA and then set method to update it
				
				//User - Show list of all selected CCAs then prompts the user to choose the ID of the CCA they want to remove
				//Once an ID is entered, use the delete function to delete chosenCCA from parent arraylist


			} else if (option == 4) {
				// Staff - Show list of all CCA and prompt the staff to enter the ID of the CCA they want to delete
				//After they enter it, use the delete function to delete CCA from CCAList
				
				//User - if(user == "user"){ 
				//        option == 5 
				//       }


			} else if (option == OPTION_QUIT) {
				//This needs to be replaced with a log out function
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	//This menu is only for CCA staff members to view
	public static void StaffMenu() {
		C206_CaseStudy.setHeader("CCA - Staff");
		System.out.println("1. Display CCA");
		System.out.println("2. Add CCA");
		System.out.println("3. Update CCA");
		System.out.println("4. Delete CCA");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	
	//This menu is only for the user to view
	public static void UserMenu() {
		C206_CaseStudy.setHeader("CCA - parent");
		System.out.println("1. Display CCA");
		System.out.println("2. Select CCA");
		System.out.println("3. Remove existing CCA");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	
	//================================= Option 1 View all CCA =================================
	



}

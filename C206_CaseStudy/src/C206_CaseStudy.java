import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class C206_CaseStudy {
	private static final int OPTION_QUIT = 5;
	static boolean login = true;
	static boolean checkvalidlogin = false;
	private static final int OPTION_UPDATE = 8;
	public static void main(String[] args) {
		ArrayList<Database> DatabaseList = new ArrayList<Database>();
		ArrayList<Parent> ParentList = new ArrayList<Parent>();
		ArrayList<Staff> StaffList = new ArrayList<Staff>();
		ArrayList<Register> RegisterList = new ArrayList<Register>();
		ArrayList<CCA> CCAList = new ArrayList<CCA>();

        DatabaseList.add(new Database ("123", "John Doe"));
		RegisterList.add(new Register("123", "John Doe", "6-B", "Desmond Lee", "Jane Doe", "JaneDoe@gmail.com",
				"98765432"));
		ParentList.add(new Parent("abcdef", "98765432",  "", ""));
		StaffList.add(new Staff("staffID123", "pass123"));
		CCAList.add(new CCA(0, "Soccer", "It's a sport where you kick balls into nets", 25, "Wednesday", "2:30", "Field", "David Tan"));
		CCAList.add(new CCA(1, "Basketball", "It's a sport where you throw balls into hoops", 30, "Friday", "2:30", "Basketball court", "Jack Johnson"));
		CCAList.add(new CCA(2, "Concert Band", "It's a CCA where people play musical instruments", 60, "Tuesday and Friday", "3:30", "Room D-4", "Alvin Tay"));
		CCAList.add(new CCA(3, "Going home club", "It's not a CCA, you just go home", 1, "Everyday", "Depends", "School Gate", "Yourself"));
		int option = 0;
		String userID;
		String user = "Nobody yet";
		
		cca_category C1 = new cca_category("Sports"); 
	    cca_category C2 = new cca_category("Performing arts"); 
	    cca_category C3 = new cca_category("Uniform group"); 
	    cca_category C4 = new cca_category("Clubs and Society"); 
	       
	      ArrayList<cca_category> catList = new ArrayList<cca_category>(); 
	      catList.add(C1); 
	      catList.add(C2); 
	      catList.add(C3); 
	      catList.add(C4); 
		
		//NOTE
		//Needs a login function because
		//This whole thing needs a boolean function depending on who logged in, where if String user; is "Staff", it shows options and functions meant for staff only
		//and if String user; is "User", it shows options and functions meant for user
		//It can either be put in else if (option == 2 && user == "Staff") {activate function meant for staff}
		//Or it can be if else inside the options
		
		
		
		while (option != OPTION_QUIT) {
			
       	    
    	    while (login) {
    	    	
    		
    			C206_CaseStudy.LoginMenu();
    			int Logintype = Helper.readInt("Enter an option > ");
    			
    			switch(Logintype) {
    			
    			//Student
                case 1:
                	userID = Helper.readString("Enter your ID > ");
               	    String name = Helper.readString("Enter your name > ");
            		for (int i = 0; i < DatabaseList.size(); i++) {
            			if (DatabaseList.get(i) != null) {
            				if(DatabaseList.get(i).getStudentID().equals(userID) && DatabaseList.get(i).getStudentName().equals(name)) {
            					user = "user";
            					login = false;
            					checkvalidlogin = true;
            					System.out.println("Login successful!");
            					break;
            				}else {
            					checkvalidlogin = false;
            					System.out.println("Incorrect ID or name :(");
            					break;
            				}
            		    }
            	    }	
                break;
                
                //Parent
                case 2:      
                	String ccaRID = Helper.readString("Enter CCA Registration ID > ");
               	    userID = Helper.readString("Enter student ID > ");
               	    String phoneNum = Helper.readString("Enter your phone number > ");
            		for (int i = 0; i < ParentList.size(); i++) {
            			if (ParentList.get(i) != null) {
            				if(ParentList.get(i).getSpecialID().equals(ccaRID) && DatabaseList.get(i).getStudentID().equals(userID) && RegisterList.get(i).getsParentContactNum().equals(phoneNum)) {
            					user = "user";
            					login = false;
            					checkvalidlogin = true;
            					System.out.println("Login successful!");
            					break;
            				}else {
            					checkvalidlogin = false;
            					System.out.println("Incorrect CCA Registration ID or student ID :(");
            					break;
            				}
            		    }
            	    }	
                break; 
                
                //Staff
                case 3:
                	userID = Helper.readString("Enter your ID > ");
               	    String password = Helper.readString("Enter password > ");
            		for (int i = 0; i < StaffList.size(); i++) {
            			if (StaffList.get(i) != null) {
            				if(StaffList.get(i).getStaffID().equals(userID) && StaffList.get(i).getStaffPassword().equals(password)) {
            					user = "staff";
            					login = false;
            					checkvalidlogin = true;
            					System.out.println("Login successful!");
            					break;
            				}else {
            					checkvalidlogin = false;
            					System.out.println("Incorrect username or password :(");
            					break;

            				}
            		    }
            	    }	
                break;
                
                //Register
                case 4:
                	Random r = new Random();
                	String alphabet = "0123456789abcdefghijklmnopqrstuvwxyz";
                    String pass = "";
                	String sID = Helper.readString("Enter your child's student ID > ");
                	String sName = Helper.readString("Enter your child's full name > ");
                	String sClass = Helper.readString("Enter your child's class > ");
                	String sTeacher = Helper.readString("Enter your child's teacher > ");
                	String sParent = Helper.readString("Enter your name > ");
                	String sParentEmail = Helper.readString("Enter your email address > ");
                	String sParentContactNum = Helper.readString("Enter your phone number > ");


            		for (int i = 0; i < DatabaseList.size(); i++) {
            			if (DatabaseList.get(i) != null) {
            				if(DatabaseList.get(i).getStudentID().equals(sID) && DatabaseList.get(i).getStudentName().equals(sName)) {
            				    for (int k = 0; k < 7; k++) {
            				        pass += alphabet.charAt(r.nextInt(alphabet.length()));
            				    }

            				    RegisterList.add(new Register(sID, sName, sClass, sTeacher, sParent, sParentEmail, sParentContactNum));
            				    ParentList.add(new Parent(pass, sParentContactNum,  "", ""));

            					checkvalidlogin = true;
            					System.out.println("Registration successful! Your CCA registration ID is: " + pass);  
            					break;
            				}else {
            					checkvalidlogin = false;
            					System.out.println("Please enter the correct information!");
            					break;
            				}
            		    }
            		}
                break;
                
              //Exit
                case 5:
                  option = OPTION_QUIT;
  				  System.out.println("Bye!");
  				  break;
    			}
    	    }
    	    
    	    
			
			//change to C206_CaseStudy.UserMenu(); to see what parent and students see
			
			if(user == "user"){
				C206_CaseStudy.UserMenu();
		    }
			else if(user == "staff"){
			C206_CaseStudy.StaffMenu();
			}
			
			option = Helper.readInt("Enter an option > ");
			if (option == 1) {
				// View all CCA
				C206_CaseStudy.ViewCCA(CCAList);
				
			} else if (option == 2) {
				//Staff - Add a new CCA
				//User - combine view all items and add a function to select a CCA and add it to parentList
				if (user == "staff") {
					int cID = Helper.readInt("Enter CCA ID > ");
					String cTitle = Helper.readString("Enter CCA name > ");
					String cDes = Helper.readString("Enter CCA description > ");
					int cSize = Helper.readInt("Enter CCA size: ");
					String cDay = Helper.readString("Enter CCA date(s) > ");
					String cTime = Helper.readString("Enter CCA timing > ");
					String cVenue = Helper.readString("Enter CCA venue > ");
					String cInstructor = Helper.readString("Enter CCA Instructor > ");
					
					CCA newCCA = new CCA(cID, cTitle, cDes, cSize, cDay, cTime, cVenue, cInstructor);
					
					boolean result = C206_CaseStudy.AddCCA(CCAList, newCCA);
					
					if (result == true) {
						System.out.println("CCA added!");
					} else {
						System.out.println("CCA NOT added, you must include all details!");
					}
					 
			    } else if (user == "user") { 
			     C206_CaseStudy.ViewCCA(CCAList); 
			     int ID = Helper.readInt("Enter a CCA ID to enter CCA> "); 
			     for (int i = 0; i < CCAList.size(); i++) { 
			      if (CCAList.get(i).getID() == ID && CCAList.get(i).getClassSize() != 0) { 
			       System.out.println("Student added into CCA"); 
			       // StudentInCCAList.add(user); 
			       CCAList.get(i).setClassSize((CCAList.get(i).getClassSize() - 1)); 
			       break; 
			      } else { 
			       System.out.println("Failed to add Student into CCA as it is full"); 
			       C206_CaseStudy.StaffMenu(); 
			       option = Helper.readInt("Enter option > "); 
			       break; 
			      } 
			     } 
			    }
				
			} else if (option == 3) {
				// View all CCA Categories
				C206_CaseStudy.ViewCCACategories(catList);
				
			} else if (option == 4) {
				//Staff - Add a CCA Category
				//User - Remove existing CCA
				if(user == "staff") {
					C206_CaseStudy.AddCCACategory(catList);
				}else if(user == "user"){ 
				 //
				}
			
			          
			} else if (option == 5) {
				//Staff - Delete a Category
				//User - Exit
				if(user == "staff") {
					C206_CaseStudy.DeleteCCACategory(catList);
				}else if(user == "user"){ 
				  option = OPTION_QUIT;
				  System.out.println("Bye!");
				}
				 
			} else if (option == 6) {
				// Update CCA
				//After clicking 6, the system displays different things depending on who's logged in
				
				//Staff - Show list of all CCA and prompt the staff to enter the ID of the CCA they want to update
				//then it prompts the user to choose which detail they want to update, there's title, description, classSize, day, time, venue, instructor
				//Use get method when they select a CCA and then set method to update it
				
				//User - Show list of all selected CCAs then prompts the user to choose the ID of the CCA they want to remove
				//Once an ID is entered, use the delete function to delete chosenCCA from parent arraylist
				if(user == "staff") {
					 C206_CaseStudy.ViewCCA(CCAList); 
				     int ID = Helper.readInt("Enter a CCA ID to enter CCA> "); 
				     for (int i = 0; i < CCAList.size(); i++) { 
				      if (CCAList.get(i).getID() == ID && CCAList.get(i).getClassSize() != 0) { 
				       System.out.println("Student added into CCA"); 
				       // StudentInCCAList.add(user); 
				       CCAList.get(i).setClassSize((CCAList.get(i).getClassSize() - 1)); 
				       break; 
				      } else { 
				       System.out.println("Failed to add Student into CCA as it is full"); 
				       C206_CaseStudy.StaffMenu(); 
				       option = Helper.readInt("Enter option > "); 
				       break; 
				      } 
				     } 
				    
				}else if(user == "user"){ 
				 //
				}
			} else if (option == 7) {
				// Staff - Show list of all CCA and prompt the staff to enter the ID of the CCA they want to delete
				//After they enter it, use the delete function to delete CCA from CCAList
				if(user == "staff") {
					C206_CaseStudy.DeleteCCA(CCAList);
				}else if(user == "user"){ 
				  option = OPTION_QUIT;
				  System.out.println("Bye!");
				}
			} else if (option == OPTION_QUIT) {
				//This needs to be replaced with a log out function
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		  
		}
	 }
	
	
	//Login Menu
	public static void LoginMenu() {
		C206_CaseStudy.setHeader("Login as...");
		System.out.println("1. Student");
		System.out.println("2. Parent");
		System.out.println("3. Staff");
		System.out.println("4. Don't have an account? Sign up here");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}
	//This menu is only for CCA staff members to view
	public static void StaffMenu() {
		C206_CaseStudy.setHeader("CCA - Staff");
		System.out.println("1. Display CCA");
		System.out.println("2. Add CCA");
		System.out.println("3. Display CCA Categories");
		System.out.println("4. Add CCA Category");
		System.out.println("5. Delete CCA Category");
		System.out.println("6. Update CCA");
		System.out.println("7. Delete CCA");
		System.out.println("8. Quit");
		Helper.line(80, "-");
	}
	
	//This menu is only for the user to view
	public static void UserMenu() {
		C206_CaseStudy.setHeader("CCA - user");
		System.out.println("1. Display CCA");
		System.out.println("2. Select CCA");
		System.out.println("3. Display CCA Categories");
		System.out.println("4. Remove existing CCA");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}
	
	// menu
	public static void UpdateCCADetailMenu() { 
	  C206_CaseStudy.setHeader("CCA - UPDATE DETAILS"); 
	  System.out.println("1. Title"); 
	  System.out.println("2. Desciption"); 
	  System.out.println("3. Class Size"); 
	  System.out.println("4. Day"); 
	  System.out.println("5. Time"); 
	  System.out.println("6. Venue"); 
	  System.out.println("7. Instructor"); 
	  System.out.println("8. Back"); 
	  Helper.line(80, "-"); 
	 
	 }
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	
	
	//================================= Option 1 View all CCA =================================
	public static void ViewCCA(ArrayList<CCA> CCAList) {
		System.out.println(String.format("%-5s %-25s %-25s %-15s %-20s %-10s %-25s %-20s", "ID", "Title", "Instructor", "Class Size", "Day", "Time", "Venue", "Description"));
		for (int i = 0; i < CCAList.size(); i++) {
			if (CCAList.get(i) != null) {
			CCAList.get(i).displayCCA();
		}
	  }	
	}
	
	//=============================== Option 2 Add a CCA (STAFF) ===============================
	public static boolean AddCCA(ArrayList<CCA> CCAList, CCA cca ) {
		for (int i = 0; i < CCAList.size(); i++) {
			if (cca.getID() < 0 || cca.getID() == CCAList.get(i).getID()) {
				System.out.println("CCA ID already taken!");
				return false;
			}
			
			else if (cca.getTitle().equals(null) || cca.getDescription().equals(null) 
				|| cca.getClassSize() < 1 || cca.getDay().equals(null) || cca.getTime().equals(null) 
				|| cca.getVenue().equals(null) || cca.getInstructor().equals(null)) {
					return false;
				}
			}
		
		CCAList.add(cca);
		return true;
	}
	//============================ Option 3 View all CCA Categories ===========================
		public static void ViewCCACategories(ArrayList<cca_category> catList) {
			System.out.println("CCA Categories");
			for (int i = 0; i < catList.size(); i++) {
		          if (catList.get(i) != null) {
		          catList.get(i).displaycat();
		        }
		          }
			}
		
	//=========================== Option 4 Add CCA Category (STAFF) ===========================
		public static void AddCCACategory(ArrayList<cca_category> catList) {
			String CCAcategory = Helper.readString("Enter CCA Category > ");
			
			cca_category news = new cca_category(CCAcategory);
		    boolean result = cca_category.add(catList,news);
		    
		    if (result == true) {
		    	System.out.println("Category added!"); 
		    } else { 
				System.out.println("Category NOT added, you must include all details!");
				}
		    }
				
	//=========================== Option 5 Delete CCA Category (STAFF)==========================
		public static void DeleteCCACategory(ArrayList<cca_category> catList) {
			C206_CaseStudy.ViewCCACategories(catList);
			int deletecat = Helper.readInt("Enter category to delete > "); 
	         cca_category A=catList.get(deletecat);
	        
	            if ( A != null) { 
	             System.out.println(A); 
	             char toDelete = Helper.readChar("Do you wish to delete this CCA category?(y/n) > "); 
	         
	             if (toDelete == 'y') { 
	              boolean deleted = catList.remove(A); 
	         
	              if (deleted == true) { 
	               System.out.println(String.format("CCA category %s was deleted successfully.", 
	                 deletecat)); 
	              } else { 
	               System.out.println("Something went wrong, CCA category was not deleted."); 
	              } 
	             } 
	         
	            } else { 
	             System.out.println("That CCA category does not exist!"); 
	            }		
			}
		
	//================================= Option 6 Update CCA  ================================
		public static void updateCCADetails(ArrayList<CCA> CCAList) { 
			boolean isValid = false; 
			  int updateOption = 0; 
			  while (isValid == false) { 
			 
			   isValid = true; 
			   C206_CaseStudy.ViewCCA(CCAList); 
			   int ID = Helper.readInt("Enter a CCA ID > "); 
			   for (int i = 0; i < CCAList.size(); i++) { 
			    if (CCAList.get(i).getID() == ID) { 
			     C206_CaseStudy.UpdateCCADetailMenu(); 
			     while (updateOption != OPTION_UPDATE) { 
			      if ((isValid == true) && updateOption == 1) { 
			       String title = Helper.readString("Enter new title > "); 
			       CCAList.get(i).setTitle(title); 
			       System.out.println("Title Updated"); 
			       break; 
			      } else if ((isValid == true) && updateOption == 2) { 
			       String description = Helper.readString("Enter new description > "); 
			       CCAList.get(i).setDescription(description); 
			       System.out.println("Description Updated"); 
			       break; 
			      } else if ((isValid == true) && updateOption == 3) { 
			       int classSize = Helper.readInt("Enter new class size > "); 
			       CCAList.get(i).setClassSize(classSize); 
			       System.out.println("Class Size Updated"); 
			       break; 
			      } else if ((isValid == true) && updateOption == 4) { 
			       String day = Helper.readString("Enter new day > "); 
			       CCAList.get(i).setDay(day); 
			       System.out.println("Day Updated"); 
			       break; 
			      } else if ((isValid == true) && updateOption == 5) { 
			       String time = Helper.readString("Enter new time > "); 
			       CCAList.get(i).setTime(time); 
			       System.out.println("Time Updated"); 
			       break; 
			      } else if ((isValid == true) && updateOption == 6) { 
			       String venue = Helper.readString("Enter new venue > "); 
			       CCAList.get(i).setVenue(venue); 
			       System.out.println("Venue Updated"); 
			       break; 
			      } else if ((isValid == true) && updateOption == 7) { 
			       String instructor = Helper.readString("Enter new instructor > "); 
			       CCAList.get(i).setInstructor(instructor); 
			       System.out.println("Instructor Updated"); 
			       break; 
			      } else if ((isValid == true) && updateOption == 8) { 
			       isValid = false; 
			       C206_CaseStudy.StaffMenu(); 
			       Helper.readInt("Enter option > "); 
			       break; 
			      } else { 
			       System.out.println("Update Failed "); 
			       isValid = false; 
			       C206_CaseStudy.StaffMenu(); 
			       Helper.readInt("Enter option > "); 
			       break; 
			      } 
			     } 
			    } 
			   } 
			  } 
			 }
	
	//================================= Option 7 Delete CCA =================================
	public static void DeleteCCA(ArrayList<CCA> CCAList) {
		C206_CaseStudy.ViewCCA(CCAList);
		int ID = Helper.readInt("Enter a CCA ID > ");
		for (int i = 0; i < CCAList.size(); i++) {
			if (CCAList.get(i).getID() == ID) {
			CCAList.remove(i);
		}
	  }
		System.out.println("CCA removed!");
		
		//Auto increment ID
		for (int i = 0; i < CCAList.size(); i++) {
			CCAList.get(i).setID(i);
		}
	  }	
	}
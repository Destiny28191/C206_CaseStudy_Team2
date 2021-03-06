import java.util.ArrayList;
import java.util.Random;

public class C206_CaseStudy {
  private static final int OPTION_QUIT = 15;
  static boolean login = true;
  static boolean checkvalidlogin = false;
  private static final int OPTION_UPDATE = 8;
  private static final int OPTION_UPDATEP = 4;

  public static void main(String[] args) {
    // testing something
    ArrayList<Database> DatabaseList = new ArrayList<Database>();
    ArrayList<Parent> ParentList = new ArrayList<Parent>();
    ArrayList<Staff> StaffList = new ArrayList<Staff>();
    ArrayList<Register> RegisterList = new ArrayList<Register>();
    ArrayList<CCA> CCAList = new ArrayList<CCA>();

    DatabaseList.add(new Database("123", "John Doe"));
    DatabaseList.add(new Database("456", "Mary Tay"));
    DatabaseList.add(new Database("789", "Bryan Lim"));
    DatabaseList.add(new Database("101", "Sally Tan"));

    RegisterList.add(
        new Register("123", "John Doe", "6-B", "Desmond Lee", "Jane Doe", "JaneDoe@gmail.com", "98765432"));

    ParentList.add(new Parent("abcdef", "Jane Doe", "JaneDoe@gmail.com", "98765432", "123", "", ""));

    StaffList.add(new Staff("staffID123", "pass123"));

    CCAList.add(new CCA(0, "Soccer", "It's a sport where you kick balls into nets", 25, "Wednesday", "2:30",
        "Field", "David Tan"));
    CCAList.add(new CCA(1, "Basketball", "It's a sport where you throw balls into hoops", 30, "Friday", "2:30",
        "Basketball court", "Jack Johnson"));
    CCAList.add(new CCA(2, "Concert Band", "It's a CCA where people play musical instruments", 60,
        "Tuesday and Friday", "3:30", "Room D-4", "Alvin Tay"));
    CCAList.add(new CCA(3, "Going home club", "It's not a CCA, you just go home", 1, "Everyday", "Depends",
        "School Gate", "Yourself"));

    studentcca sc1 = new studentcca("basketball", "johntan");
    ArrayList<studentcca> sclist = new ArrayList<studentcca>();
    sclist.add(sc1);

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

    // NOTE
    // Needs a login function because
    // This whole thing needs a boolean function depending on who logged in, where
    // if String user; is "Staff", it shows options and functions meant for staff
    // only
    // and if String user; is "User", it shows options and functions meant for user
    // It can either be put in else if (option == 2 && user == "Staff") {activate
    // function meant for staff}
    // Or it can be if else inside the options

    while (option != OPTION_QUIT) {

      while (login != false) {

        C206_CaseStudy.LoginMenu();
        int Logintype = Helper.readInt("Enter an option > ");

        switch (Logintype) {

        // Student
        case 1:
          userID = Helper.readString("Enter your ID > ");
          String name = Helper.readString("Enter your name > ");
          for (int i = 0; i < DatabaseList.size(); i++) {
            if (DatabaseList.get(i) != null) {
              if (DatabaseList.get(i).getStudentID().equals(userID)
                  && DatabaseList.get(i).getStudentName().equals(name)) {
                user = "user";
                login = false;
                checkvalidlogin = true;
                System.out.println("Login successful!");
                break;
              }
            }
          }
          if (checkvalidlogin = false) {
            System.out.println("Incorrect ID or name :(");
          }
          break;
	// Parent
        case 2:
          String ccaRID = Helper.readString("Enter CCA Registration ID > ");
          userID = Helper.readString("Enter student ID > ");
          for (int i = 0; i < ParentList.size(); i++) {
            if (ParentList.get(i) != null) {
              if (ParentList.get(i).getSpecialID().equals(ccaRID)
                  && ParentList.get(i).getStudentID().equals(userID)) {
                user = "user";
                login = false;
                checkvalidlogin = true;
                System.out.println("Login successful!");
                break;
              }
            }
          }
          if (checkvalidlogin = false) {
            System.out.println("Incorrect CCA Registration ID or student ID :(");
          }
          break;

        // Staff
        case 3:
          userID = Helper.readString("Enter your ID > ");
          String password = Helper.readString("Enter password > ");
          for (int i = 0; i < StaffList.size(); i++) {
            if (StaffList.get(i) != null) {
              if (StaffList.get(i).getStaffID().equals(userID)
                  && StaffList.get(i).getStaffPassword().equals(password)) {
                user = "staff";
                login = false;
                checkvalidlogin = true;
                System.out.println("Login successful!");
                break;
              }
            }
          }
          if (checkvalidlogin = false) {
            System.out.println("Incorrect username or password :(");
          }
          break;

        // Register
        case 4:
          C206_CaseStudy.RegisterParents(DatabaseList, ParentList, RegisterList);
          break;

        // Exit
        case 5:
          option = OPTION_QUIT;
          login = false;
          System.out.println("Bye!");
          break;
        }
      }

      // change to C206_CaseStudy.UserMenu(); to see what parent and students see

      if (user == "user") {
        C206_CaseStudy.UserMenu();
      } else if (user == "staff") {
        C206_CaseStudy.StaffMenu();
      }

      option = Helper.readInt("Enter an option > ");
      if (option == 1) {
        // Staff - View database
        // User - View all CCAs
        if (user == "staff") {
          Helper.line(80, "-");
          System.out.println("Database");
          Helper.line(80, "-");
          C206_CaseStudy.ViewDatabase(DatabaseList);
        } else if (user == "user") {
          C206_CaseStudy.ViewCCA(CCAList);
        }

      } else if (option == 2) {
        // Staff - Add a student into database
        // User - combine view all items and add a function to select a CCA and add it
        // to parentList
        if (user == "staff") {
          C206_CaseStudy.AddStudentData(DatabaseList);
        } else if (user == "user") {
          C206_CaseStudy.ViewCCA(CCAList);
          int ID = Helper.readInt("Enter a CCA ID to enter CCA> ");
          C206_CaseStudy.addStudentToCCA(CCAList, ID);
        }

      } else if (option == 3) {
        // Staff - Delete a student from database
        // User - View all CCA categories
        if (user == "staff") {
          C206_CaseStudy.DeleteStudentData(DatabaseList);
        } else if (user == "user") {
          C206_CaseStudy.ViewCCACategories(catList);
        }

      } else if (option == 4) {
        // Staff - View Registration List
        // User - Show list of all selected CCAs then prompts the user to choose the ID
        // of the CCA they want to remove
        // Once an ID is entered, use the delete function to delete chosenCCA from
        // parent arraylist
        if (user == "staff") {
          Helper.line(80, "-");
          System.out.println("Registration List");
          Helper.line(80, "-");
          C206_CaseStudy.ViewRegistration(RegisterList);
        } else if (user == "user") {

        }
	 } else if (option == 5) {
        // Staff - Delete Parent
        // User - Exit
        if (user == "staff") {
          C206_CaseStudy.DeleteParent(RegisterList, ParentList);
        } else if (user == "user") {
          option = OPTION_QUIT;
          System.out.println("Bye!");
        }

      } else if (option == 6) {
        // Staff - Update Parent
        // User - Exit
        if (user == "staff") {
          C206_CaseStudy.UpdateParentDetails(ParentList, RegisterList);
        } else if (user == "user") {
          option = OPTION_QUIT;
          System.out.println("Bye!");
        }

      } else if (option == 7) {
        // Staff - View all CCAs
        // User - Exit
        if (user == "staff") {
          C206_CaseStudy.ViewCCA(CCAList);
        } else if (user == "user") {
          option = OPTION_QUIT;
          System.out.println("Bye!");
        }

      } else if (option == 8) {
        // Staff - Add a new CCA
        // User - Exit
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
          option = OPTION_QUIT;
          System.out.println("Bye!");
        }

      } else if (option == 9) {
        // Staff - Show list of all CCA and prompt the staff to enter the ID of the CCA
        // they want to delete
        // After they enter it, use the delete function to delete CCA from CCAList.
        // User - Exit
        if (user == "staff") {
          C206_CaseStudy.DeleteCCA(CCAList);
        } else if (user == "user") {
          option = OPTION_QUIT;
          System.out.println("Bye!");
        }

      } else if (option == 10) {
        // Staff - Update CCA
        // Staff - Show list of all CCA and prompt the staff to enter the ID of the CCA
        // they want to update
        // then it prompts the user to choose which detail they want to update, there's
        // title, description, classSize, day, time, venue, instructor
        // Use get method when they select a CCA and then set method to update it

        // User - Exit
        if (user == "staff") {
          C206_CaseStudy.UpdateCCADetails(CCAList);
        } else if (user == "user") {
          option = OPTION_QUIT;
          System.out.println("Bye!");
        }

      } else if (option == 11) {
        // Staff - View all CCA Categories
        // User - Exit
        if (user == "staff") {
          C206_CaseStudy.ViewCCACategories(catList);
        } else if (user == "user") {
          option = OPTION_QUIT;
          System.out.println("Bye!");
        }

      } else if (option == 12) {
        // Staff - Add CCA Categories
        // User - Exit
        if (user == "staff") {
          C206_CaseStudy.AddCCACategory(catList);
        } else if (user == "user") {
          option = OPTION_QUIT;
          System.out.println("Bye!");
        }
	      } else if (option == 13) {
        // Staff - Delete a CCA Category
        // User - Exit
        if (user == "staff") {
          C206_CaseStudy.DeleteCCACategory(catList);
        } else if (user == "user") {
          option = OPTION_QUIT;
          System.out.println("Bye!");
	}
      } else if (option == 14) {
        // Staff - Update a CCA Category
        // User - Exit
        if (user == "staff") {
          C206_CaseStudy.UpdateCCACategory(catList);
        } else if (user == "user") {
          option = OPTION_QUIT;
          // System.out.println("Bye!");
          System.out.println("Logged out!");
          C206_CaseStudy.LoginMenu();

        }
      } else if (option == OPTION_QUIT) {
        // This needs to be replaced with a log out function
        // System.out.println("Bye!");
        System.out.println("Logged out!");
        C206_CaseStudy.LoginMenu();
        int Logintype = Helper.readInt("Enter an option > ");
        switch (Logintype) {

        // Student
        case 1:
          userID = Helper.readString("Enter your ID > ");
          String name = Helper.readString("Enter your name > ");
          for (int i = 0; i < DatabaseList.size(); i++) {
            if (DatabaseList.get(i) != null) {
              if (DatabaseList.get(i).getStudentID().equals(userID)
                  && DatabaseList.get(i).getStudentName().equals(name)) {
                user = "user";
                login = false;
                checkvalidlogin = true;
                System.out.println("Login successful!");
                break;
              }
            }
          }
          if (checkvalidlogin = false) {
            System.out.println("Incorrect ID or name :(");
          }
          break;

        // Parent
        case 2:
          String ccaRID = Helper.readString("Enter CCA Registration ID > ");
          userID = Helper.readString("Enter student ID > ");
          for (int i = 0; i < ParentList.size(); i++) {
            if (ParentList.get(i) != null) {
              if (ParentList.get(i).getSpecialID().equals(ccaRID)
                  && ParentList.get(i).getStudentID().equals(userID)) {
                user = "user";
                login = false;
                checkvalidlogin = true;
                System.out.println("Login successful!");
                break;
              }
            }
          }
          if (checkvalidlogin = false) {
            System.out.println("Incorrect CCA Registration ID or student ID :(");
          }
          break;

        // Staff
        case 3:
          userID = Helper.readString("Enter your ID > ");
          String password = Helper.readString("Enter password > ");
          for (int i = 0; i < StaffList.size(); i++) {
            if (StaffList.get(i) != null) {
              if (StaffList.get(i).getStaffID().equals(userID)
                  && StaffList.get(i).getStaffPassword().equals(password)) {
                user = "staff";
                login = false;
                checkvalidlogin = true;
                System.out.println("Login successful!");
                break;
              }
            }
          }
          if (checkvalidlogin = false) {
            System.out.println("Incorrect username or password :(");
          }
          break;

        // Register
        case 4:
          C206_CaseStudy.RegisterParents(DatabaseList, ParentList, RegisterList);
          break;

        // Exit
        case 5:
          option = OPTION_QUIT;
          login = false;
          System.out.println("Bye!");
          break;

        }
// change to C206_CaseStudy.UserMenu(); to see what parent and students see

        if (user == "user") {
          C206_CaseStudy.UserMenu();
        } else if (user == "staff") {
          C206_CaseStudy.StaffMenu();
        }

        option = Helper.readInt("Enter an option > ");

      } else {
        System.out.println("Invalid option");
      }
    }
  }

  // Login Menu
  public static void LoginMenu() {
    C206_CaseStudy.setHeader("Login as...");
    System.out.println("1. Student");
    System.out.println("2. Parent");
    System.out.println("3. Staff");
    System.out.println("4. Don't have an account? Sign up here");
    System.out.println("5. Quit");
    Helper.line(80, "-");
  }

  // This menu is only for CCA staff members to view
  public static void StaffMenu() {
    C206_CaseStudy.setHeader("CCA - Staff");
    System.out.println("1. View database");
    System.out.println("2. Add student");
    System.out.println("3. Delete student");
    System.out.println("4. View Registration List");
    System.out.println("5. Delete parent");
    System.out.println("6. Update parent");
    System.out.println("7. Display CCAs");
    System.out.println("8. Add CCA");
    System.out.println("9. Delete CCA");
    System.out.println("10. Update CCA");
    System.out.println("11. Display CCA Categories");
    System.out.println("12. Add CCA Category");
    System.out.println("13. Delete CCA Category");
    System.out.println("14. Update CCA Category");
    System.out.println("15. Quit");
    Helper.line(80, "-");
  }

  // This menu is only for the user to view
  public static void UserMenu() {
    C206_CaseStudy.setHeader("CCA - user");
    System.out.println("1. Display CCAs");
    System.out.println("2. Select CCA");
    System.out.println("3. Display CCA Categories");
    System.out.println("4. Remove existing CCA");
    System.out.println("5. Quit");
    Helper.line(80, "-");
  }

  // Update CCA menu
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

  // Parent menu
  public static void UpdateParentMenu() {
    C206_CaseStudy.setHeader("Parent - UPDATE DETAILS");
    System.out.println("1. Parent Name");
    System.out.println("2. Parent Email");
    System.out.println("3. Parent Contact Number");
    System.out.println("4. Back");
    Helper.line(80, "-");

  }

  public static void setHeader(String header) {
    Helper.line(80, "-");
    System.out.println(header);
    Helper.line(80, "-");
  }

  // ============================== View Database (STAFF) ==============================
  public static void ViewDatabase(ArrayList<Database> DatabaseList) {
    System.out.println(String.format("%-20s %-20s", "Student ID", "Student Name"));
    for (int i = 0; i < DatabaseList.size(); i++) {
      if (DatabaseList.get(i) != null) {
        DatabaseList.get(i).displayDatabase();
      }
    }
  }

  // ======================== Add student into Database (STAFF) ========================
  public static void AddStudentData(ArrayList<Database> DatabaseList) {
    String dID = Helper.readString("Enter student ID > ");
    String dName = Helper.readString("Enter student Name > ");

    Database newData = new Database(dID, dName);
    boolean dresult = Database.add(DatabaseList, newData);

    if (dresult == true) {
      System.out.println("Student added into Database!");
    } else {
      System.out.println("Student NOT added into Database, you must include all details!");
    }
  }
	// ======================== Delete student from Database (STAFF) ========================
  public static void DeleteStudentData(ArrayList<Database> DatabaseList) {
    boolean D = false;
    int E = 0;
    C206_CaseStudy.ViewDatabase(DatabaseList);
    String deleteData = Helper.readString("Enter student ID to delete: ");
    for (int i = 0; i < DatabaseList.size(); i++) {
      if (DatabaseList.get(i).getStudentID().equals(deleteData)) {
        D = true;
        E = i;
      }
    }

    if (D == true) {
      System.out.println(deleteData);
      char toDelete = Helper.readChar("Do you wish to delete this Student?(y/n) > ");

      if (toDelete == 'y') {
        DatabaseList.remove(E);

        System.out.println(String.format("Student %s was deleted successfully.", deleteData));
      } else {
        System.out.println("Something went wrong, Student was not deleted.");
      }
    }

    else {
      System.out.println("That Student does not exist!");
    }
  }

  // ================================= Register parents (PARENT) ================================
  public static void RegisterParents(ArrayList<Database> DatabaseList, ArrayList<Parent> ParentList,
      ArrayList<Register> RegisterList) {
    boolean successfulRegister = false;
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
        if (DatabaseList.get(i).getStudentID().equals(sID)
            && DatabaseList.get(i).getStudentName().equals(sName)) {
          for (int k = 0; k < 7; k++) {
            pass += alphabet.charAt(r.nextInt(alphabet.length()));
          }

          RegisterList
              .add(new Register(sID, sName, sClass, sTeacher, sParent, sParentEmail, sParentContactNum));
          ParentList.add(new Parent(pass, sID, sParent, sParentEmail, sParentContactNum, "", ""));

          successfulRegister = true;
          System.out.println("Registration successful! Your CCA registration ID is: " + pass);
          break;
        }
      }
    }
    if (successfulRegister == false) {
      System.out.println("Please enter the correct information!");
    }
  }

  // ================================= View Registration List =================================
  public static void ViewRegistration(ArrayList<Register> RegisterList) {
    System.out.println(String.format("%-8s %-20s %-15s %-20s %-20s %-25s %-15s\n", "ID", "Student Name", "Class",
        "Teacher", "Parent Name", "Email Address", "Contact Number"));
    for (int i = 0; i < RegisterList.size(); i++) {
      if (RegisterList.get(i) != null) {
        RegisterList.get(i).displayRegistration();
      }
    }
  }

  // ======================== Delete Parent (STAFF) ========================
  public static void DeleteParent(ArrayList<Register> RegisterList, ArrayList<Parent> ParentList) {
    boolean P = false;
    int Q = 0;
    C206_CaseStudy.ViewRegistration(RegisterList);
    String deleteSID = Helper.readString("Enter Student ID > ");
    String deleteParentP = Helper.readString("Enter Phone Number > ");
    for (int i = 0; i < ParentList.size(); i++) {
      if (ParentList.get(i).getStudentID().equals(deleteSID)
          && ParentList.get(i).getPhoneNumber().equals(deleteParentP)) {
        P = true;
        Q = i;
      }
    }

    if (P == true) {
      System.out.println(deleteSID);
      System.out.println(deleteParentP);
      char toDelete = Helper.readChar("Do you wish to delete this Parent?(y/n) > ");
	    if (toDelete == 'y') {
        RegisterList.remove(Q);
        ParentList.remove(Q);
        System.out.println(String.format("Parent with student ID %s was deleted successfully.", deleteSID));
      } else {
        System.out.println("Something went wrong, Parent was not deleted.");
      }
    }

    else {
      System.out.println("That Parent does not exist!");
    }
  }

  // ================================= Update Parent Details (STAFF) ================================
  public static void UpdateParentDetails(ArrayList<Parent> ParentList, ArrayList<Register> RegisterList) {
    boolean isValidP = false;
    int updateOptionP = 0;
    while (isValidP == false) {
      isValidP = true;
      C206_CaseStudy.ViewRegistration(RegisterList);
      String ID = Helper.readString("Enter student ID > ");
      for (int i = 0; i < RegisterList.size(); i++) {
        if (RegisterList.get(i).getsID().equals(ID)) {
          C206_CaseStudy.UpdateParentMenu();
          updateOptionP = Helper.readInt("Enter a update Parent option > ");
          while (updateOptionP != OPTION_UPDATEP) {
            if ((isValidP == true) && updateOptionP == 1) {
              String pName = Helper.readString("Enter new name > ");
              RegisterList.get(i).setsParentName(pName);
              ParentList.get(i).setName(pName);
              System.out.println("Name Updated!");
              break;
            } else if ((isValidP == true) && updateOptionP == 2) {
              String pEmail = Helper.readString("Enter new email address > ");
              RegisterList.get(i).setsParentEmail(pEmail);
              ParentList.get(i).setEmail(pEmail);
              System.out.println("Email address Updated!");
              break;
            } else if ((isValidP == true) && updateOptionP == 3) {
              String pContact = Helper.readString("Enter new phone number > ");
              RegisterList.get(i).setsParentContactNum(pContact);
              ParentList.get(i).setPhoneNumber(pContact);
              System.out.println("Phone number Updated!");
              break;
            } else if ((isValidP == true) && updateOptionP == 4) {
              isValidP = false;
              C206_CaseStudy.StaffMenu();
              Helper.readInt("Enter option > ");
              break;
            } else {
              System.out.println("Update Failed ");
              isValidP = false;
              C206_CaseStudy.UpdateParentDetails(ParentList, RegisterList);
              Helper.readInt("Enter a update Parent option > ");
              break;
            }
          }
        }
      }
    }
  }

  // ================================= View all CCA =================================
  public static void ViewCCA(ArrayList<CCA> CCAList) {
    System.out.println(String.format("%-5s %-25s %-25s %-15s %-20s %-10s %-25s %-20s", "ID", "Title", "Instructor",
        "Class Size", "Day", "Time", "Venue", "Description"));
    for (int i = 0; i < CCAList.size(); i++) {
      if (CCAList.get(i) != null) {
        CCAList.get(i).displayCCA();
      }
    }
  }

  // =============================== Add a CCA (STAFF) ===============================
  public static boolean AddCCA(ArrayList<CCA> CCAList, CCA cca) {
    for (int i = 0; i < CCAList.size(); i++) {
      if (cca.getID() < 0 || cca.getID() == CCAList.get(i).getID()) {
        System.out.println("CCA ID already taken!");
        return false;
      }

      else if (cca.getTitle().equals(null) || cca.getDescription().equals(null) || cca.getClassSize() < 1
          || cca.getDay().equals(null) || cca.getTime().equals(null) || cca.getVenue().equals(null)
          || cca.getInstructor().equals(null)) {
        return false;
      }
    }

    CCAList.add(cca);
    return true;
  }
	// ================================= Delete CCA (STAFF) =================================
  public static void DeleteCCA(ArrayList<CCA> CCAList) {
    C206_CaseStudy.ViewCCA(CCAList);
    int ID = Helper.readInt("Enter a CCA ID > ");
    for (int i = 0; i < CCAList.size(); i++) {
      if (CCAList.get(i).getID() == ID) {
        CCAList.remove(i);
      }
    }
    System.out.println("CCA removed!");

    // Auto increment ID
    for (int i = 0; i < CCAList.size(); i++) {
      CCAList.get(i).setID(i);
    }
  }

  // ================================= Update CCA (STAFF) ================================
  public static void UpdateCCADetails(ArrayList<CCA> CCAList) {
    boolean isValid = false;
    int updateOption = 0;
    while (isValid == false) {
      isValid = true;
      C206_CaseStudy.ViewCCA(CCAList);
      int ID = Helper.readInt("Enter a CCA ID > ");
      for (int i = 0; i < CCAList.size(); i++) {
        if (CCAList.get(i).getID() == ID) {
          C206_CaseStudy.UpdateCCADetailMenu();
          updateOption = Helper.readInt("Enter a update CCA option > ");
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
              C206_CaseStudy.UpdateCCADetailMenu();
              Helper.readInt("Enter a update CCA option > ");
              break;
            }
          }
        }
      }
    }
  }
          
      
  //=========================== Add student to CCA ==========================
    public static void AddStudentcca(ArrayList<studentcca> sclist) {
          String Scca = Helper.readString("Enter cca");
          String Sname = Helper.readString("Enter studentname ");
      
      studentcca newScca = new studentcca(Scca, Sname);
        boolean SCresult = studentcca.add(sclist,newScca);
        
        if (SCresult == true) {
          System.out.println("Student added into cca"); 
        } else { 
        System.out.println("Student NOT added into Database, you must include all details!");
        }
	    }  


  // ============================ View all CCA Categories ===========================
  public static void ViewCCACategories(ArrayList<cca_category> catList) {
    System.out.println("CCA Categories");
    for (int i = 0; i < catList.size(); i++) {
      if (catList.get(i) != null) {
        catList.get(i).displaycat();
      }
    }
  }

  // =========================== Add CCA Category (STAFF) ===========================
  public static void AddCCACategory(ArrayList<cca_category> catList) {
    String CCAcategory = Helper.readString("Enter CCA Category > ");

    cca_category news = new cca_category(CCAcategory);
    boolean result = cca_category.add(catList, news);

    if (result == true) {
      System.out.println("Category added!");
    } else {
      System.out.println("Category NOT added, you must include all details!");
    }
  }

  // =========================== Delete CCA Category (STAFF)==========================
  public static void DeleteCCACategory(ArrayList<cca_category> catList) {
    boolean A = false;
    int B = 0;
    C206_CaseStudy.ViewCCACategories(catList);
    String deletecat = Helper.readString("Enter category to delete: ");
    for (int i = 0; i < catList.size(); i++) {
      if (catList.get(i).getcategory().equals(deletecat)) {
        A = true;
        B = i;
      }
    }

    if (A == true) {
      System.out.println(deletecat);
      char toDelete = Helper.readChar("Do you wish to delete this CCA category?(y/n) > ");

      if (toDelete == 'y') {
        catList.remove(B);

        System.out.println(String.format("CCA category %s was deleted successfully.", deletecat));
      } else {
        System.out.println("Something went wrong, CCA category was not deleted.");
      }
    }

    else {
      System.out.println("That CCA category does not exist!");
    }

  }

  // =========================== Update CCA Category (STAFF) ===========================
  public static void UpdateCCACategory(ArrayList<cca_category> catList) {
    C206_CaseStudy.ViewCCACategories(catList);
    String CCAcategory = Helper.readString("Enter the CCA Category to update: > ");
    String updatecca = Helper.readString("Enter new CCA category >  ");

    boolean CA = false;
    int C = 0;
    cca_category news = new cca_category(updatecca);
    for (int i = 0; i < catList.size(); i++) {
      if (catList.get(i).getcategory().equals(CCAcategory)) {
        CA = true;
        C = i;
      }
    }

    if (CA == true) {
      System.out.println(catList.get(C).getcategory());
      char toupdate = Helper.readChar("Do you wish to update this CCA category?(y/n) > ");

      if (toupdate == 'y') {
        catList.get(C).setcategory(updatecca);

        System.out.println("CCA category was updated successfully!");
      } else {
        System.out.println("Something went wrong, CCA category was not updated.");
      }
    }
  }
  
  //================================- Add student to CCA(USER) =====================
    public static void addStudentToCCA(ArrayList<CCA> CCAList , int ID) {
  boolean status = false;
    for (int i = 0; i < CCAList.size(); i++) { 
     if (CCAList.get(i).getID() == ID && CCAList.get(i).getClassSize() != 0) { 
      System.out.print("Student added into CCA\n"); 
      // StudentInCCAList.add(user); 
      CCAList.get(i).setClassSize((CCAList.get(i).getClassSize() - 1)); 
      status = true;
      break;
     } else if (CCAList.get(i).getID() == ID && CCAList.get(i).getClassSize() == 0) { 
      System.out.println("Failed to add Student into CCA as it is full\n"); 
      status = true;
      break;
     }
    }
     if (status == false){
         System.out.print("Please enter a valid CCA ID\n"); 
       }
    }
}

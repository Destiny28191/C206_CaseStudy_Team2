import java.util.ArrayList;

public class cca_category {
	
	  private String category;
	  public cca_category(String category) {
	    super();
	    this.category = category;
	}
	  public String getcategory() {
	    return category;
	  }

	  public void setcategory(String category) {
	    this.category = category;
	  }
	  public void displaycat() {
	    String output = String.format("%-25s\n", "CATEGORY");
	    output += String.format("%-25s\n", category);
	    System.out.println(output);
	  }
	  public static boolean add(ArrayList<cca_category> catList, cca_category cCAcategory) {
	    catList.add(cCAcategory);
	    return true;
	    
	  }
	   
	}

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	cca_category C1 = new cca_category("Sports"); 
    cca_category C2 = new cca_category("Performing arts"); 
    cca_category C3 = new cca_category("Uniform group"); 
    cca_category C4 = new cca_category("Clubs and Society"); 
       
      ArrayList<cca_category> catList = new ArrayList<cca_category>(); 

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void c206_test() {
		//fail("Not yet implemented"); 
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

//============================== View/Add/Delete Category ==============================
	@Test
	  public void testAddcategory() {
	    //fail("Not yet implemented");
	    // write your code here
	    assertNotNull("Test if there is valid category list arraylist to add to", catList);

	        //Given an empty list, after adding 1 item, the size of the list is 1
	        cca_category.add(catList, C1);
	        assertEquals("Test if that Category arraylist size is 1?", 1, catList.size());

	        //The item just added is as same as the first item of the list
	        assertSame("Test that Category is added same as 1st item of the list?", C1, catList.get(0));

	        //Add another item. test The size of the list is 2?
	        cca_category.add(catList, C2);
	        assertEquals("Test that category arraylist size is 2?", 2, catList.size());

	        assertSame("Error message", C2, catList.get(1));
	  }
	
	@Test 
	   public void testRemoveCCAcategory() { 
	    //Test if Item List is not null 
	    assertNotNull("Test if there is valid Category arraylist to delete to", catList); 
	    //Add items into the array list 
	    cca_category.add(catList, C1); 
	    cca_category.add(catList, C2); 
	    assertEquals("Test if that Category arraylist size is 2?", 2, catList.size()); 
	    //Test remove one item 
	    catList.remove(C1); 
	    assertEquals("Test if that Category arraylist size is 1?", 1, catList.size()); 
	    //Test remove last item 
	    catList.remove(C2); 
	    //Test that array list is empty 
	   
	    assertEquals("Test if that Category arraylist size is 0?", 0, catList.size()); 
	}
	
	 @Test 
	   public void testRetrieveAllcategory() { 
	    // Test if Item list is not null but empty, so that can add a new item 
	    assertNotNull("Test if there is valid Category arraylist to add to", catList); 
	     
	    //test if the list of Academic Clusters retrieved is empty 
	    assertEquals("Test if that Category arraylist size is 0?", 0, catList.size()); 
	       
	    //Given an empty list, after adding 2 items, test if the size of the list is 2 
	      cca_category.add(catList, C1); 
	      cca_category.add(catList, C2); 
	    assertEquals("Test if that Category=arraylist size is 2?", 2, catList.size()); 
	     
	    //test if the expected output string same as the list of Academic Cluster retrieved 
	    String input = "Sports";
	    String input2 = "Performing arts";
	      cca_category A=catList.get(0);
	      cca_category B=catList.get(1);
	        
	    assertEquals("Check that ViewCCACategories", input, A);
	    assertEquals("Check that ViewCCACategories", input2, B);
	}
	 
//======================================================================================

}

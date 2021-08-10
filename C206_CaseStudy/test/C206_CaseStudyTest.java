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
      
     CCA cca1 = new CCA(0, "Soccer", "It's a sport where you kick balls into nets", 25, "Wednesday", "2:30", "Field", "David Tan"); 
     CCA cca2 = new CCA(1, "Basketball", "It's a sport where you throw balls into hoops", 30, "Friday", "2:30", "Basketball court", "Jack Johnson"); 
     CCA cca3 = new CCA(2, "Concert Band", "It's a CCA where people play musical instruments", 60, "Tuesday and Friday", "3:30", "Room D-4", "Alvin Tay"); 
     CCA cca4 = new CCA(3, "Going home club", "It's not a CCA, you just go home", 1, "Everyday", "Depends", "School Gate", "Yourself"); 
     ArrayList<CCA> CCAList = new ArrayList<CCA>();   
     
     Parent parent1 = new Parent("abcdef", "98765432", "",  "", "");
     ArrayList<Parent> ParentList = new ArrayList<Parent>();
     
     
     Register registered1 = (new Register("123", "John Doe", "6-B", "Desmond Lee", "Jane Doe", "JaneDoe@gmail.com","98765432"));
     ArrayList<Register> RegisterList = new ArrayList<Register>();
     

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
	    
	   
	        
	    assertSame("Check that ViewAllCategorylist", catList.get(0),C1);
	    assertSame("Check that ViewAllCategorylist",  catList.get(1),C2);
	}
	
	@Test
    public void testRetrieveAllParent() {
        // Test if Item list is not null but empty, so that can add a new item
        assertNotNull("Test if there is valid Parent arraylist to add to", ParentList);

 

        // test if the list of Academic Clusters retrieved is empty
        assertEquals("Test if that Parent arraylist size is 0?", 0, ParentList.size());

 

        // Given an empty list, after adding 2 items, test if the size of the list is 2
        Parent.add(ParentList, parent1);
        assertEquals("Test if that Parent arraylist size is 1?", 1, ParentList.size());

 

        // test if the expected output string same as the list of Academic Cluster
        // retrieved

 

        assertSame("Check that ViewAllParentlist", ParentList.get(0), parent1);

    }
	

    @Test
    public void testRemoveParent() {
        // Test if Item List is not null
        assertNotNull("Test if there is valid Parent arraylist to add to", ParentList);
        // Add items into the array list
        Parent.add(ParentList, parent1);
        assertEquals("Test if that Parent arraylist size is 1?", 1, ParentList.size());

 

        // Test remove the item
        ParentList.remove(parent1);
        // Test that array list is empty
        assertEquals("Test if that Parent arraylist size is 0?", 0, ParentList.size());
    }

 

    @Test
    public void testAddParent() {
        // fail("Not yet implemented");
        // write your code here
        assertNotNull("Test if there is valid Parent list arraylist to add to", ParentList);

 

        // Given an empty list, after adding 1 item, the size of the list is 1
        Parent.add(ParentList, parent1);
        assertEquals("Test if that Parent arraylist size is 1?", 1, ParentList.size());

 

        // The item just added is as same as the item of the list
        assertSame("Test that Parent is added same as 1st item of the list?", parent1, ParentList.get(0));

 

    }
    
    @Test
    public void testRegisterParent() {
        // fail("Not yet implemented");
        // write your code here
        assertNotNull("Test if there is valid Parent list arraylist to add to", ParentList);

 

        // Given an empty list, after adding 1 item, the size of the list is 1
        Parent.add(ParentList, parent1);
        assertEquals("Test if that Parent arraylist size is 1?", 1, ParentList.size());

 

        // The item just added is as same as the item of the list
        assertSame("Test that Parent is added same as 1st item of the list?", parent1, ParentList.get(0));

 

    }
	 
//======================================================================================
	
	
//============================== add CCA ==============================
//	@Test pls fix this ty
//	  public void testRetrieveAllCCA() {
//		 // Test if Item list is not null but empty, so that can add a new item  
//	     assertNotNull("Test if there is valid CCA arraylist to add to", CCAList); 
//	      
//	       
//	     //test if the list of Academic Clusters retrieved is empty  
//	     assertEquals("Test if that CCA arraylist size is 0?", 0, CCAList.size());  
//	         
//	     //Given an empty list, after adding 2 items, test if the size of the list is 2  
//	       CCA.add(CCAList, cca1);  
//	       CCA.add(CCAList, cca2);  
//	       CCA.add(CCAList, cca3);  
//	       CCA.add(CCAList, cca4);  
//	     assertEquals("Test if that CCA arraylist size is 4?", 4, CCAList.size());  
//	       
//	     //test if the expected output string same as the list of Academic Cluster retrieved  
//	            
//	     assertSame("Check that ViewAllCCAlist", CCAList.get(0),cca1); 
//	     assertSame("Check that ViewAllCCAlist",  CCAList.get(1),cca2); 
//	     assertSame("Check that ViewAllCCAlist", CCAList.get(2),cca3); 
//	     assertSame("Check that ViewAllCCAlist",  CCAList.get(3),cca4); 
//	}
}

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ListDetailsHelper;
import model.ListDetails;
import model.ListItem;
import model.Zoo;

/**  * @author Gabriel Woodburn - gwoodburn  * CIS175 - Spring 2021  * Mar 2, 2021  */

public class AnimalTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zoo bill = new Zoo("Bill");
		
		ListDetailsHelper ldh = new ListDetailsHelper();
		
		ListItem deoderant = new ListItem("Target", "Deoderant");
		ListItem chips = new ListItem("Target", "Chips");
		
		List<ListItem> billItems = new ArrayList<ListItem>();
		//billItems.add(deoderant);
		//billItems.add(chips);
		
		//ListDetails billList = new ListDetails("Bill's ShoppingList", LocalDate.now(), bill);
		
		//ldh.insertNewListDetails(billList);
		
		List<ListDetails>  allLists = ldh.getLists();
		for(ListDetails a: allLists) {
			List<ListItem> list = a.getListOfItems();
			System.out.println(a.toString());
			for (ListItem b: list)
			{
				System.out.println(b.getAnimal());
			}
				
		}
	}

}

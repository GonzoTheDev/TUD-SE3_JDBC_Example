import java.util.*;

public class JDBCExercise {

	public static void main(String[] args) {
		
		// Create a DAO instance
		MySqlCustomerDao myDAO = new MySqlCustomerDao();
		
		// Search for customer by ID using DAO method and assign it as a customer object
		Customer myCust = myDAO.findCustomerById(103);
		
		// Print all attribute information for the customer that has been found
		System.out.println("\nCustomer Information: \n");
		System.out.println(
				"Customer ID: " + myCust.getCustomerNumber() + "\n" +
				"Customer Name: " + myCust.getCustomerName() + "\n" +
				"Contact First Name: " + myCust.getContactFirstName() + "\n" +
				"Contact Last Name: " + myCust.getContactLastName() + "\n" +
				"Phone: " + myCust.getPhone() + "\n" +
				"Address Line 1: " + myCust.getAddressLine1() + "\n" +
				"Address Line 2: " + myCust.getAddressLine2() + "\n" +
				"City: " + myCust.getCity() + "\n" +
				"State: " + myCust.getState() + "\n" +
				"Postal Code: " + myCust.getPostalCode() + "\n" +
				"Country: " + myCust.getCountry() + "\n" +
				"Sales Rep Employee Number: " + myCust.getSalesRepEmployeeNumber() + "\n" +
				"Credit Limit: " + myCust.getCreditLimit() + "\n"
				);
		

		// Use updateCustomer function to update customer 347's credit limit
		myDAO.updateCustomer(60000, 347);
		
		// Create a customer object with the ID 347
		Customer myUpdateCust = myDAO.findCustomerById(347);
		
		// Print the customers credit limit to show it has been updated
		System.out.println("\nThe customers credit limit is: ");
		System.out.println(myUpdateCust.getCreditLimit());
		
		
		// Create an array list of customers and use the DAO method to search for a name, store results in array list
		List<Customer> customers = myDAO.selectCustomersByName("At");
		
		// Create a list iterator and initialize it as null
		ListIterator<Customer> litr = null;
		
		// Assign the customers array list to the iterator
		litr = customers.listIterator();
		
		System.out.println("\nYour search returned the following name(s): \n");
		
		// Iterate the array list and print out the customers names that have been found in the search
		while(litr.hasNext()){
		       System.out.println(litr.next().getCustomerName());
		    }
		
		
		
		

	}

}

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlCustomerDao implements CustomerDao {

	@Override
	public List<Customer> selectCustomersByName(String name) {
		Connection conn = getConnection();
		String name_search = name;
		List<Customer> customers = new ArrayList<Customer>();
		
		try {

			// Get a statement from the connection
			Statement stmt = conn.createStatement() ;

			// Execute the query
			ResultSet rs = stmt.executeQuery( "SELECT * FROM customer where customerName like '%" + name_search + "%'");
			
			// While loop to get each column in the result and store in customer object then add to array list
			while(rs.next()) {
				Customer cust = new Customer();
				// Set all attributes of customer object
				cust.setCustomerName(rs.getString(2));
				cust.setContactLastName(rs.getString(3));
				cust.setContactFirstName(rs.getString(4));
				cust.setPhone(rs.getString(5));
				cust.setAddressLine1(rs.getString(6));
				cust.setAddressLine2(rs.getString(7));
				cust.setCity(rs.getString(8));
				cust.setState(rs.getString(9));
				cust.setPostalCode(rs.getString(10));
				cust.setCountry(rs.getString(11));
				cust.setSalesRepEmployeeNumber(rs.getInt(12));
				cust.setCreditLimit(rs.getDouble(13));
				customers.add(cust);
			}
		}catch (SQLException e) {
				e.printStackTrace();
			}
			
		return customers;
	}

	@Override
	public Customer findCustomerById(int customerNumber) {
		
		Connection conn = getConnection();
		Customer myCust = new Customer();
		myCust.setCustomerNumber(customerNumber);
		int custNo = customerNumber;
		
		try {

		// Get a statement from the connection
		Statement stmt = conn.createStatement() ;

		// Execute the query
		ResultSet rs = stmt.executeQuery( "SELECT * FROM customer where customerNumber = '" + custNo + "'" );
		
		// While loop to get each column in the result and store in customer object
		while(rs.next()) {

			// Set all attributes of customer object
			myCust.setCustomerName(rs.getString(2));
			myCust.setContactLastName(rs.getString(3));
			myCust.setContactFirstName(rs.getString(4));
			myCust.setPhone(rs.getString(5));
			myCust.setAddressLine1(rs.getString(6));
			myCust.setAddressLine2(rs.getString(7));
			myCust.setCity(rs.getString(8));
			myCust.setState(rs.getString(9));
			myCust.setPostalCode(rs.getString(10));
			myCust.setCountry(rs.getString(11));
			myCust.setSalesRepEmployeeNumber(rs.getInt(12));
			myCust.setCreditLimit(rs.getDouble(13));
			
			
		}

		return myCust;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Connection getConnection() {

			// Get a connection to the database
			Connection conn;
			try {
				conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/test", "root", "" );
				return conn;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return null;

			
	}
	
	public void updateCustomer(double credLim, int CustID) {
		Connection conn = getConnection();
		int custNo = CustID;
		String sql_query = "UPDATE customer SET creditLimit = '" + credLim + "' where customerNumber = '" + custNo + "'";
		
		try {

		// sends queries and receives results
		PreparedStatement statement = conn.prepareStatement(sql_query);

		// Execute the query
		int count= statement.executeUpdate();
		
		System.out.print("Number of rows updated: " + count + ". \n");
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

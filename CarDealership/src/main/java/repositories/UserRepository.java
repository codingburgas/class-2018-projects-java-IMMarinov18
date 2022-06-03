package repositories;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.User;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;

public class UserRepository {
	private String url = "jdbc:sqlserver://SD2312\\SQLEXPRESS;databaseName=Car Dealership;integratedSecurity=true";
	private Connection conn;

	public UserRepository() throws SQLException {

		System.out.println("Connecting...");
		conn = DriverManager.getConnection(url);
		System.out.println("Connected!");

	}

	public void CloseConnection() throws SQLException {
		conn.close();
	}

	public void ShowCustomers() throws SQLException {
		String query1 = "SELECT * "
				+ "FROM Car c "
				+ "JOIN [User] u "
				+ "ON c.CarId = u.Car_id";
		
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {
			String cstFmt = String.format("%d %s %s %d %s %s %s %d %s %s %s %s %s %d %d", rs.getInt("id"), 
					rs.getString("FirstName"), rs.getString("LastName"),rs.getInt("PhoneNumber"),
					rs.getString("City"), rs.getString("Address"), rs.getString("State"), 
					rs.getInt("PostalCode"), rs.getString("Email"), rs.getString("UserName"),
					rs.getString("Password"), rs.getString("Category"), rs.getString("Model"), rs.getInt("Year"), rs.getInt("CarId"));
			System.out.println(cstFmt);
		}
	}

// shows first name of the customer by id
	public void showCustomerById(Integer id) throws SQLException {
		String idStr = id.toString();
		String query1 = "SELECT * "
				+ "FROM Car c "
				+ "JOIN [User] u "
				+ "ON c.id = u.Car_id WHERE id = ?";

		PreparedStatement stmt = conn.prepareStatement(query1);

		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			String cstFmt = String.format("%d %s %s %d %d %d %s", rs.getInt("id"), rs.getString("Category"),
					rs.getString("Model"), rs.getInt("Year"), rs.getInt("SerialNumber"), rs.getInt("DealershipEstateId"), rs.getString("Category"));

			System.out.println(cstFmt);
		}
	}

// Updates the customers first name by id
	public void updateCustomer(int id, String Fname, String Lname) throws SQLException {
		String query1 = "UPDATE Car " + "SET FirstName = ?, LastName = ? " + "WHERE Id = ?";

		PreparedStatement stmt = conn.prepareStatement(query1);

		stmt.setString(1, Fname);
		stmt.setString(2, Lname);
		stmt.setInt(3, id);

		int rs = stmt.executeUpdate();

		System.out.println(String.format("Rows affected: %d", rs));
	}

	public void deleteCustomer(Integer id) throws SQLException {
		String idStr = id.toString();
		String query1 = "DELETE FROM Car " + "WHERE Id = ?";

		PreparedStatement stmt = conn.prepareStatement(query1);

		stmt.setInt(1, id);

		int rs = stmt.executeUpdate();

		System.out.println(String.format("Rows affected: %d", rs));

	}

	public List<User> GetCustomers() throws SQLException {

		List<User> customers = new ArrayList<User>();
		String query1 = "SELECT TOP 9 * FROM Car";

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {
			String cstFmt = String.format("%d %s %s %d %d %d", rs.getInt("id"), rs.getString("Category"),
					rs.getString("Model"), rs.getInt("Year"), rs.getInt("SerialNumber"), rs.getInt("DealershipEstateId"));
			System.out.println(cstFmt);
		}
		return customers;
	}
	
	
	public void insertUser(String FirstName, String LastName, int PhoneNumber, String City, String Address, String State, int PostalCode, String Email, String UserName, String Password, int Car_id)
	throws SQLException {
	String query1 = "EXEC [dbo].[Procedurka]"
	+ " @FirstName = ? , "
	+ " @LastName = ? , "
	+ " @PhoneNumber = ? , "
	+ " @City = ? , "
	+ " @StateProvince = ? , "
	+ " @PostalCode = ? , "
	+ " @Email = ? "
	+ " @UserName = ? "
	+ " @Password = ? " 
	+ " @Car_id = ? ";
	PreparedStatement stmt = conn.prepareStatement(query1); stmt.setString(1, FirstName);
	stmt.setString(2, LastName);
	stmt.setInt(3, PhoneNumber);
	stmt.setString(4, City);
	stmt.setString(5, Address);
	stmt.setString(6, State);
	stmt.setInt(6, PostalCode);
	stmt.setString(7, Email);
	stmt.setString(8, UserName);
	stmt.setString(9, Password);
	stmt.setInt(10, Car_id);
	
	stmt.setInt(11, Car_id); int rs = stmt.executeUpdate(); System.out.println(String.format("Gutou"));
	}



	public void getUsers() {
		
	}

	public void User(String FirstName, String LastName,int PhoneNumber,String City,String Address,String State,int PostalCode,String Email,String UserName,String Password,int Car_id ) {
		String query = "INSERT INTO [dbo].[User] (FirstName, LastName, PhoneNumber, City, Address, State, PostalCode, Email, UserName, Password, Car_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, FirstName);
			ps.setString(2, LastName);
			ps.setInt(3, PhoneNumber);
			ps.setString(4, City);
			ps.setString(5, Address);
			ps.setString(6, State);
			ps.setInt(7, PostalCode);
			ps.setString(8, Email);
			ps.setString(9, UserName);
			ps.setString(10, Password);
			ps.setInt(11, Car_id);
			
			ps.executeUpdate();
			
			System.out.println("User has been inserted.");
		} catch(SQLException exc) {
			exc.printStackTrace();
		}
	}


		
	}
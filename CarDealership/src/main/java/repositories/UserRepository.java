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
				+ "ON c.id = u.Car_id";

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {
			String cstFmt = String.format("%d %s %s %d %s %s %s %d %s %s %s %s %s %d", rs.getInt("id"), 
					rs.getString("FirstName"), rs.getString("LastName"),rs.getInt("PhoneNumber"),
					rs.getString("City"), rs.getString("Address"), rs.getString("State/Province"), 
					rs.getInt("PostalCode"), rs.getString("Email"), rs.getString("UserName"),
					rs.getString("Password"), rs.getString("Category"), rs.getString("Model"), rs.getInt("Year"));
			System.out.println(cstFmt);
		}
	}

	public void InsertCustomers(Integer id, String FirstName, String LastName, Integer PhoneNumber, String City, String Address, String StateProvince, Integer PostalCode, String Email, String UserName, String Password)
			throws SQLException {
		String query1 = "INSERT INTO Patients(Id,HospitalId,FirstName,LastName,Age) " + "VALUES(?,?,?,?,?)";

		PreparedStatement stmt = conn.prepareStatement(query1);

		stmt.setInt(1, id);
		stmt.setString(2, FirstName);
		stmt.setString(3, LastName);
		stmt.setInt(4, PhoneNumber);
		stmt.setString(5, City);
		stmt.setString(6, Address);
		stmt.setString(7, StateProvince);
		stmt.setInt(8, PostalCode);
		stmt.setString(9, Email);
		stmt.setString(10, UserName);
		stmt.setString(11, Password);
		
		stmt.setString(5, City);

		int rs = stmt.executeUpdate();

		System.out.println(String.format("Rows affected: %d", rs));
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
	
	

	public List<User> getUsers() {
// TODO Auto-generated method stub
		return null;
	}
}
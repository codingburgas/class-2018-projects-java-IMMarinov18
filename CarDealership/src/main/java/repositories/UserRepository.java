package repositories;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.User;
//import sun.security.util.Password;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;

//SCHOOL: SD2312
public class UserRepository {
	private static final int Car_id = 0;
	private String url = "jdbc:sqlserver://SD2312\\SQLEXPRESS;databaseName=Car Dealership;integratedSecurity=true";
	private Connection conn;
	public User user;

	public UserRepository() throws SQLException {

		System.out.println("Connecting...");
		conn = DriverManager.getConnection(url);
		System.out.println("Connected!");

	}

	public void CloseConnection() throws SQLException {
		conn.close();
	}

	public void ShowCustomers() throws SQLException {
		String query1 = "SELECT * FROM [User]";

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {
			String cstFmt = String.format("%d %s %s %d %s %s %s %d %s %s", rs.getInt("id"),
					rs.getString("FirstName"), rs.getString("LastName"), rs.getInt("PhoneNumber"), rs.getString("City"),
					rs.getString("Address"), rs.getString("State"), rs.getInt("PostalCode"), rs.getString("Email"),
					rs.getString("UserName"), rs.getString("Password"));
			System.out.println(cstFmt);
		}
	}

	public void ShowCars() throws SQLException {
		String query1 = "SELECT * FROM [Car]";

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {
			String cstFmt = String.format("%d %s %s %d %d %f", rs.getInt("CarId"), rs.getString("Category"),
					rs.getString("Model"), rs.getInt("Year"), rs.getInt("SerialNumber"), rs.getDouble("Price"));
			System.out.println(cstFmt);
		}
	}

	public void insertUser(String FirstName, String LastName, int PhoneNumber, String City, String Address,
			String State, int PostalCode, String Email, String UserName, String Password, String Role) {
		String query = "INSERT INTO [dbo].[User] (FirstName, LastName, PhoneNumber, City, Address, State, PostalCode, Email, UserName, Password, Role) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
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
			ps.setString(11, Role);

			ps.executeUpdate();

			System.out.println("User has been inserted.");
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}

	public void insertCar(String Category, String Model, int Year, int serialNumber, double Price) {
		String query = "INSERT INTO [dbo].[Car] (Category, Model, Year, SerialNumber, Price) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, Category);
			ps.setString(2, Model);
			ps.setInt(3, Year);
			ps.setInt(4, serialNumber);
			ps.setDouble(5, Price);

			ps.executeUpdate();

			System.out.println("Car has been inserted.");
		} catch (SQLException exc) {
			exc.printStackTrace();
		}
	}

	// shows first name of the customer by id
	public void showUserById(Integer id) throws SQLException {
		String idStr = id.toString();
		String query1 = "SELECT * FROM [User] " + "WHERE UserId = ?";

		PreparedStatement stmt = conn.prepareStatement(query1);

		stmt.setInt(1, id);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			String cstFmt = String.format("%d %s %s %d %s %s %s %d %s %s %s %s %s %d %d", rs.getInt("id"),
					rs.getString("FirstName"), rs.getString("LastName"), rs.getInt("PhoneNumber"), rs.getString("City"),
					rs.getString("Address"), rs.getString("State"), rs.getInt("PostalCode"), rs.getString("Email"),
					rs.getString("UserName"), rs.getString("Password"), rs.getString("Category"), rs.getString("Model"),
					rs.getInt("Year"), rs.getInt("CarId"));
			System.out.println(cstFmt);
		}
	}

// Updates the customers first name by id
	
	public void updateCar(int id, double price, Integer year) throws SQLException {
		String query1 = "UPDATE Car " + "SET Price = ?, Year = ? " + " WHERE CarId = ? ";
		PreparedStatement stmt = conn.prepareStatement(query1);
		stmt.setDouble(1, price);
		stmt.setInt(2, year);
		stmt.setInt(3, id);



		int rs = stmt.executeUpdate();



		System.out.println(String.format("Successfully update this car: %d", rs));
		}
	
	
	
	public void updateUser(int id, String FirstName, String LastName) throws SQLException {
		String query1 = "UPDATE [User] " + "SET FirstName = ?, LastName = ? " + "WHERE id = ?";

		PreparedStatement stmt = conn.prepareStatement(query1);

		stmt.setString(1, FirstName);
		stmt.setString(2, LastName);
		stmt.setInt(3, id);

		int rs = stmt.executeUpdate();

		System.out.println(String.format("Successfully update this user: %d", rs));
	}
	
	
	public void deleteUser(Integer id) throws SQLException {
		String idStr = id.toString();
		String query1 = "DELETE FROM [User] " + "WHERE id = ?";

		PreparedStatement stmt = conn.prepareStatement(query1);

		stmt.setInt(1, id);

		int rs = stmt.executeUpdate();

		System.out.println(String.format("Successfully deleted this user: %d", rs));

	}
	
	public void deleteCar(Integer id) throws SQLException {
		String idStr = id.toString();
		String query1 = "DELETE FROM [Car] " + "WHERE CarId = ?";

		PreparedStatement stmt = conn.prepareStatement(query1);

		stmt.setInt(1, id);

		int rs = stmt.executeUpdate();

		System.out.println(String.format("Successfully deleted this car: %d", rs));

	}
	public User login(String username, String pass) throws SQLException {

		String query1 = "SELECT * FROM [User] " + "WHERE Username = '" + username + "';";

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {
			if (rs.getString("Password").equals("pass")) {
				user = new User(Long.parseLong(rs.getString("UserId")), rs.getString("UserId"), rs.getString("UserId"));
				System.out.println("YOU HAVE LOGGED IN SUCCESSFULLY");
				return user;
				
				
			}
		}
		return null;

		// System.out.println(String.format("Rows affected: %d", rs));

	}

	public List<User> getUser() throws SQLException {

		List<User> customers = new ArrayList<User>();
		String query1 = "SELECT TOP 9 * FROM [User]";

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {
			String cstFmt = String.format("%d %s %s %d %s %s %s %d %s %s %s %s %s %d %d", rs.getInt("id"),
					rs.getString("FirstName"), rs.getString("LastName"), rs.getInt("PhoneNumber"), rs.getString("City"),
					rs.getString("Address"), rs.getString("State"), rs.getInt("PostalCode"), rs.getString("Email"),
					rs.getString("UserName"), rs.getString("Password"), rs.getString("Category"), rs.getString("Model"),
					rs.getInt("Year"), rs.getInt("CarId"));
			System.out.println(cstFmt);
		}
		return customers;
	}

	public List<User> getUsers() {
// TODO Auto-generated method stub
		return null;
	}

	public User selectUser(String userName) throws SQLException {
		String query1 = "SELECT FROM [User] " + "WHERE Username = '" + userName + "';";

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query1);

		while (rs.next()) {
			if (rs.getString("Password").equals("pass")) {
				user = new User(Long.parseLong(rs.getString("UserId")), rs.getString("UserId"), rs.getString("UserId"));
				return user;
			}
		}
		return null;
	}
}

package SQL;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import static java.nio.charset.StandardCharsets.UTF_8;

public class Connecting {
	private String url = "jdbc:sqlserver://SD2312\\sqlexpress;databaseName=Car Dealership;integratedSecurity=true";
	private Connection conn;

	public Connecting() throws SQLException {
		System.out.println("Connecting...");
		conn = DriverManager.getConnection(url);
		System.out.println("Connected!");
	}

	public void CloseConnecton() throws SQLException {
		conn.close();
	}

	public void addCars(int id, String Category, String Model, String Year, int SerialNumber, int DealershipEstateId) throws SQLException {
		String query1 = String
				.format("INSERT INTO Car ([id] ,[Category],[Model],[Year],[SerialNumber],[DealershipEstateId])"
						+ "VALUES (?,?,?,?,?)");
		PreparedStatement stmt = conn.prepareStatement(query1);
		stmt.setInt(1, id);
		stmt.setString(2, Category);
		stmt.setString(3, Model);
		stmt.setString(4, Year);
		stmt.setInt(5, SerialNumber);
		stmt.setInt(5, DealershipEstateId);
		int rs = stmt.executeUpdate();
		if (rs == 1) {
			System.out.println(rs);
		}
	}

	public void showCars() throws SQLException {
		String query1 = "SELECT * FROM Cars";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query1);
		while (rs.next()) {
			String custFmt = String.format("%d %s %s %s %s", rs.getInt("Car_id"), rs.getString("Category"),
					rs.getString("Model"), rs.getString("Year"), rs.getString("SerialNumber"),
					rs.getString("DealershipEstateId"));
			System.out.println(custFmt);
		}
	} // shows the title of the book with id "id"

	public void showCars(Integer id) throws SQLException {
		String idStr = id.toString();
		String query1 = "SELECT * FROM Car " + "WHERE Car_id = " + idStr;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query1);
		while (rs.next()) {
			String custFmt = String.format("%d %s %s %s %s", rs.getInt("Car_id"), rs.getString("Category"),
					rs.getString("Model"), rs.getString("Year"), rs.getString("SerialNumber"),
					rs.getString("DealershipEstateId"));
			System.out.println(custFmt);
		}
	} // update the first name of the customer with id "id"

	

	public void deleteCars(Integer id) throws SQLException {
		String query1 = "DELETE FROM Car " + " WHERE Car_id = ? ";
		PreparedStatement stmt = conn.prepareStatement(query1);
		stmt.setInt(1, id);
		int rs = stmt.executeUpdate();
		System.out.println(String.format("Rows affected: %d", rs));
	}
}

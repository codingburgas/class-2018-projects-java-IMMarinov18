package main;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controllers.UserController;
import repositories.UserRepository;

import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;

// Main class containing main method, i.e. start of a Java application
public class App {
	public static void main(String[] args) throws SQLException {
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, UTF_8));
// System.out.println(System.getProperty("file.encoding"));

		//UserRepository dataBase = new UserRepository();
//dataBase.ShowCustomers();
//dataBase.showCustomerById(1);
//dataBase.updateCustomer(2, "KASHA", "TODD");
//dataBase.ShowCustomers();
//dataBase.deleteCustomer(1);
//dataBase.ShowCustomers();
//dataBase.GetCustomers();
//dataBase.InsertCustomers(2, 1,"maluk", "muk",54);
//dataBase.ShowCustomers();
 UserController menu = new UserController();
	menu.optionMenu();
	}
	
}
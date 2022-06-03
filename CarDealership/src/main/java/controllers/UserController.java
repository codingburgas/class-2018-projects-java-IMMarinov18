package controllers;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import repositories.UserRepository;

public class UserController {

	public void optionMenu() throws SQLException {
		UserRepository dataBase = new UserRepository();

		Scanner x = new Scanner(System.in);

		while (true) {
			System.out.println("\r\nWelcome!");
			System.out.println("1. Customers");
			System.out.println("9. Exit");
			System.out.print("Enter your choice: ");

			try {
				int choice = x.nextInt();
				switch (choice) {
				case 1:
					subMenu(dataBase, x);
					break;
				case 9:
					System.exit(0);
					break;
				default:
					System.out.println("Wrong input! Please enter valid value\r\n");
					break;
				}

			} catch (InputMismatchException e) {
				System.out.println("Enter a numerical value!");
				x.nextLine();
			}
		}
	}

	void subMenu(UserRepository dataBase, Scanner x) throws SQLException {

		while (true) {
			System.out.println("\r\nShow info menu");
			System.out.println("1. Show user's details");
			System.out.println("2. Insert User");
			System.out.println("9. Return to main menu");
			System.out.print("Enter your choice: ");

			try {
				int choice = x.nextInt();
				switch (choice) {
				case 1:
					dataBase.ShowCustomers();

					break;
				case 2:
					System.out.print("First Name -> ");
					String FirstName=x.nextLine();
					System.out.print("LastName -> ");
					String LastName=x.nextLine();
					System.out.print("PhoneNumber -> ");
					int PhoneNumber=Integer.parseInt(x.nextLine());
					System.out.print("City -> ");
					String City=x.nextLine();
					System.out.print("Address-> ");
					String Address=x.nextLine();
					System.out.print("State -> ");
					String State=x.nextLine();
					System.out.print("PostalCode -> ");
					int PostalCode=Integer.parseInt(x.nextLine());
					System.out.print("Email -> ");
					String Email=x.nextLine();
					System.out.print("UserName -> ");
					String UserName=x.nextLine();
					System.out.println("Password -> ");
					String Password=x.nextLine();
				
		
					System.out.print("Car_id ->");
					int Car_id=Integer.parseInt(x.nextLine());
					System.out.println();
					
					dataBase.User(FirstName, LastName, PhoneNumber, City, Address, State, PostalCode, Email, UserName, Password, Car_id);
					

					break;
				case 3:
//dataBase.InsertUser();
					break;
				case 9:
					return;

				default:
					System.out.println("Wrong input! Please enter valid value\r\n");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter a numerical value!");
				x.nextLine();
			}
		}
	}

}

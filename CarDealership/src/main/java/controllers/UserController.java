package controllers;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import controllers.Session;

import repositories.UserRepository;

public class UserController {
	boolean isAdmin = false;

	private void displayMenu() {
		if (Session.isUserLoggedIn) {
			System.out.println("\r\nWelcome!");
			System.out.println("1. Customers");
			System.out.println("9. Exit");
		} else {
			System.out.println("\r\nWelcome!");
			System.out.println("1. Admin Login");
			System.out.println("2. Customer Login");
			System.out.println("9. Exit");
		}
	}

	private void handleInput(int choice) throws SQLException {

		if (Session.isUserLoggedIn) {
			UserRepository dataBase = new UserRepository();
			switch (choice) {

			case 1:
				subMenuForCustomers(dataBase, new Scanner(System.in));
				break;
			case 9:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong input! Please enter valid value\r\n");
				break;
			}
		} else {
			switch (choice) {
			case 1:
				// login
				Scanner x = new Scanner(System.in);
				System.out.println("Username: ");
				String username = x.nextLine();
				System.out.println("Password: ");
				String password = x.nextLine();
				if (username.equals("admin") && password.equals("admin123")) {
					// Is Admin
					isAdmin = true;
					Session.isUserLoggedIn = true;

				} else {
					System.out.println("Wrong admin username or password.");
				}
				break;
			case 2:
				Scanner x1 = new Scanner(System.in);
				System.out.println("Role: ");
				String Role = x1.nextLine();
				if (Role.equals("customer")) {

					Session.isUserLoggedIn = true;

					char[] subMenuForCustomers = null;
					System.out.print(subMenuForCustomers);
				} else {
					System.out.println("Wrong admin username or password.");
				}
				break;

			case 9:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong input! Please enter valid value\r\n");
				break;
			}
		}
	}

	public void optionMenu() {

		Scanner x = new Scanner(System.in);

		while (true) {
			displayMenu();
			System.out.print("Enter your choice: ");

			try {
				int choice = Integer.parseInt(x.nextLine());
				handleInput(choice);
			} catch (Exception e) {
				System.out.println("Enter a numerical value!");
			}
		}
	}

	void subMenuForCustomers(UserRepository dataBase, Scanner x) throws SQLException {

		while (true) {
			if (!isAdmin) {
			System.out.println("\r\nShow info menu");
			System.out.println("1. Insert User");
			System.out.println("2. Show Cars");
			System.out.println("9. Return to main menu");
			System.out.print("Enter your choice: ");
			
				try {
					int choice = Integer.parseInt(x.next());
					switch (choice) {
					case 1:
						System.out.print("Role -> ");
						String Role = x.nextLine();
						if(Role.isBlank()) {
							 Role = x.nextLine();
						}
						System.out.println("ROLE VALUE =" + Role);
						System.out.print("First Name -> ");
						String FirstName = x.nextLine();
						System.out.print("LastName -> ");
						String LastName = x.nextLine();
						System.out.print("PhoneNumber -> ");
						int PhoneNumber = Integer.parseInt(x.nextLine());
						System.out.print("City -> ");
						String City = x.nextLine();
						System.out.print("Address-> ");
						String Address = x.nextLine();
						System.out.print("State -> ");
						String State = x.nextLine();
						System.out.print("PostalCode -> ");
						int PostalCode = Integer.parseInt(x.nextLine());
						System.out.print("Email -> ");
						String Email = x.nextLine();
						System.out.print("UserName -> ");
						String UserName = x.nextLine();
						System.out.println("Password -> ");
						String Password = x.nextLine();

						dataBase.insertUser(FirstName, LastName, PhoneNumber, City, Address, State, PostalCode, Email,
								UserName, Password, Role);
						break;
					case 2:
						dataBase.ShowCars();
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
			}else {
				
				System.out.println("\r\nShow info menu");
				System.out.println("1. Show user's details");
				System.out.println("2. Insert User");
				System.out.println("3. Show Cars");
				System.out.println("4. Add Car");
				System.out.println("5. Delete User");
				System.out.println("6. Delete Car");
				System.out.println("9. Return to main menu");
				System.out.print("Enter your choice: ");
				
					try {
						int choice = Integer.parseInt(x.next());
						switch (choice) {
						case 1:
							dataBase.ShowCustomers();
							break;
						case 2:
							System.out.print("Role -> ");
							String Role = x.nextLine();
							if(Role.isBlank()) {
								 Role = x.nextLine();
							}
							System.out.print("First Name -> ");
							String FirstName = x.nextLine();
							System.out.print("LastName -> ");
							String LastName = x.nextLine();
							System.out.print("PhoneNumber -> ");
							int PhoneNumber = Integer.parseInt(x.nextLine());
							System.out.print("City -> ");
							String City = x.nextLine();
							System.out.print("Address-> ");
							String Address = x.nextLine();
							System.out.print("State -> ");
							String State = x.nextLine();
							System.out.print("PostalCode -> ");
							int PostalCode = Integer.parseInt(x.nextLine());
							System.out.print("Email -> ");
							String Email = x.nextLine();
							System.out.print("UserName -> ");
							String UserName = x.nextLine();
							System.out.println("Password -> ");
							String Password = x.nextLine();

							dataBase.insertUser(FirstName, LastName, PhoneNumber, City, Address, State, PostalCode, Email,
									UserName, Password, Role);
							break;
						case 3:
							dataBase.ShowCars();
							break;
						case 4:
							x.nextLine();
							System.out.print("Category -> ");
							String Category = x.nextLine();
							System.out.print("Model -> ");
							String Model = x.nextLine();
							System.out.print("Year -> ");
							int Year = Integer.parseInt(x.nextLine());
							System.out.print("Serial Number -> ");
							int Serial_Number = Integer.parseInt(x.nextLine());
							System.out.print("Price -> ");
							double Price = Double.parseDouble(x.nextLine());

							dataBase.insertCar(Category, Model, Year, Serial_Number, Price);
							break;
						case 5:
							
							dataBase.ShowCustomers();
							Integer str = Integer.parseInt(x.next());
							dataBase.deleteUser(str);
							break;
						case 6:
							dataBase.ShowCars();
							Integer str1 = Integer.parseInt(x.next());
							dataBase.deleteCar(str1);
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

}

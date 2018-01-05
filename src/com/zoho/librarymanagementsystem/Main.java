package com.zoho.librarymanagementsystem;

import java.util.Scanner;

public class Main implements Cloneable{

	
	
	public static boolean checkEqual(Object obj1, Object obj2) {
		return obj1.equals(obj2);
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{
		/*
		String yy = "raja";
		String hh = "raja";
//		System.out.println("-------" + yy.equals(hh));
		
//		Book obj1 = new Book(1, "Test", "author");
//		Book obj3 = (Book) obj1.clone();
//		Book obj2 = obj1;
		
		Book ob1 = new Book(2, "Zoho", null);
		Book ob2 = new Book(2, "Zoho", null);
//		Book ob2 = (Book) ob1.clone();
		System.out.println( ob1.equals(ob2));
		System.out.println( ob1==ob2);
		System.out.println(ob1);
		System.out.println(ob2);
		System.out.println(ob1.hashCode());
		System.out.println(ob2.hashCode());
		*/
		
		
		int regNo;
		
		Library admin = new Library();
		while (true) {
			Scanner sc = new Scanner(System.in);
			int choice;
			System.out.println("Choose your identity:");
			System.out.println("1 - Librarian");
			System.out.println("2 - Staff");
			System.out.println("3 - Student");
//			while(sc.hasNext())
				choice = sc.nextInt();
//			else
//				wait(10);
			switch (choice) {
			case 1:
				System.out.println("Choose the desired operation:");
				System.out.println("1 - Add book to database");
				System.out.println("2 - Delete book from database");
				System.out.println("3 - View book list in database");
				System.out.println("4 - Add staff to database");
				System.out.println("5 - Add student to database");
				System.out.println("6 - Remove staff from database");
				System.out.println("7 - Remove student from database");
				System.out.println("8 - View staff database");
				System.out.println("9 - View student database");

				int adminOption = sc.nextInt();
				switch (adminOption) {
				case 1:
					admin.addBook();
				break;
				case 2:
					admin.deleteBook();
				break;
				case 3:
					admin.viewBookDB();
				break;
				case 4:
					admin.addStaff();
				break;
				case 5:
					admin.addStudent();
				break;
				case 6:
					admin.removeStaff();
				break;
				case 7:
					admin.removeStudent();
				break;
				case 8:
					admin.viewStaffDB();
				break;
				case 9:
					admin.viewStudentDB();
				break;
				default:
					System.out.println("Choice not valid!");
				break;
				}
			break;
			
			case 2:
				System.out.println("Enter your registration number:");
				regNo = sc.nextInt();
				
				System.out.println("Choose the desired operation:");
				System.out.println("1 - Borrow book");
				System.out.println("2 - Return book");
				System.out.println("3 - View borrowed books");
				
				int staffOption = sc.nextInt();
				switch (staffOption) {
				case 1:
					System.out.println("Here is the list of books available");
					admin.viewBookDB();
					admin.borrowBook("Staff", regNo);
				break;
				case 2:
					try {
					System.out.println("Here is the list of books you have borrowed");
					admin.viewBookDetails("Staff", regNo);
					admin.returnBook("Staff", regNo);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				break;
				case 3:
					try {
					admin.viewBookDetails("Staff", regNo);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				break;
				default:
					System.out.println("Choice not valid!");
				break;
				}
			break;
				
			case 3:
				System.out.println("Enter your registration number:");
				regNo = sc.nextInt();
				
				System.out.println("Choose the desired operation:");
				System.out.println("1 - Borrow book");
				System.out.println("2 - Return book");
				System.out.println("3 - View borrowed books");
				
				int studentOption = sc.nextInt();
				switch (studentOption) {
				case 1:
					System.out.println("Here is the list of books available");
					admin.viewBookDB();
					admin.borrowBook("Student", regNo);
				break;
				case 2:
					try {
					System.out.println("Here is the list of books you have borrowed");
					admin.viewBookDetails("Student", regNo);
					admin.returnBook("Student", regNo);
					} catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
				break;
				case 3:
					try {
					admin.viewBookDetails("Student", regNo);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				break;
				default:
					System.out.println("Choice not valid!");
				break;
				}
			break;
	
			default:
				System.out.println("Invalid choice!");
			break;
			}
//			sc.close();
		}
	}
}
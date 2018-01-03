package com.zoho.librarymanagementsystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int regNo;
		Scanner sc = new Scanner(System.in);
		AdminTransaction admin = new AdminTransaction();
		StaffTransaction staff = new StaffTransaction();
		StudentTransaction student = new StudentTransaction();
		while (true) {
			
			System.out.println("Choose your identity:");
			System.out.println("1 - Librarian");
			System.out.println("2 - Staff");
			System.out.println("3 - Student");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Choose the desired operation:");
				System.out.println("1 - Add book to database");
				System.out.println("2 - Delete book from database");
				System.out.println("3 - View book list in database");
				System.out.println("4 - View staff database");
				System.out.println("5 - View student database");
				
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
					admin.viewStaffDB();
				break;
				case 5:
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
//						ArrayList<StaffTransaction> arrayList=StaffTransaction.ob;
//						staff=arrayList.get(1);
//						staff.borrowBook();
						admin.borrowBook("Staff", regNo);
					break;
					case 2:
						try {
						System.out.println("Here is the list of books you have borrowed");
						admin.viewBookDetails("Staff", regNo);
						admin.returnBook("Staff", regNo);
//						staff.returnBook();
						} catch (Exception e) {
							System.out.println(e.getMessage());
						}
					break;
					case 3:
						try {
//						staff.viewBorrowedBooks();
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
//						ArrayList<Student Transaction> arrayList=StudentTransaction.ob;
//						student=arrayList.get(1);
//						student.borrowBook();
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
//						student.returnBook();
					break;
					case 3:
						try {
						student.viewBorrowedBooks();
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

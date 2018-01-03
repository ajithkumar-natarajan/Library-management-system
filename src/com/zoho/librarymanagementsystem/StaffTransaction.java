package com.zoho.librarymanagementsystem;

import java.util.ArrayList;
//import java.util.Scanner;

public class StaffTransaction {
	private StaffDB staff;
//	private Scanner input;
	private int regNo;
	static ArrayList<StaffTransaction> ob=new ArrayList<>();
	
	public StaffTransaction() {
		staff = new StaffDB();
//		System.out.println("Enter your registration number:");
//		input = new Scanner(System.in);
//		regNo = input.nextInt();
	}
	
	public void returnBook() {
		Transaction transactBook = new ReturnBook();
		int id = transactBook.transactBook();
		staff.removeBook(regNo, id);
	}
	
	public void borrowBook() {
		Transaction transactBook = new BorrowBook();
		int id = transactBook.transactBook();
		staff.addBook(regNo, id);
	}
	
	public void viewBorrowedBooks() {
		staff.viewBorrowedBooks(regNo);
	}
}

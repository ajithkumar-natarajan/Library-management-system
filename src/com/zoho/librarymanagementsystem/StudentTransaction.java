package com.zoho.librarymanagementsystem;

import java.util.Scanner;

public class StudentTransaction {
	private StudentDB student;
	private Scanner input;
	private int regNo;
	
	public StudentTransaction() {
		student = new StudentDB();
//		System.out.println("Enter your registration number:");
//		input = new Scanner(System.in);
//		regNo = input.nextInt();
	}
	
	public void returnBook() {
		Transaction transactBook = new ReturnBook();
		int id = transactBook.transactBook();
		System.out.println(regNo);
		System.out.println(id);
		student.removeBook(regNo, id);
	}
	
	public void borrowBook() {
		Transaction transactBook = new BorrowBook();
		int id = transactBook.transactBook();
		student.addBook(regNo, id);
	}
	
	public void viewBorrowedBooks() {
		student.viewBorrowedBooks(regNo);
	}
}

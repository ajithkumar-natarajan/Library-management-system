package com.zoho.librarymanagementsystem;

import java.util.Scanner;

public class BorrowBook implements Transaction {
	private Scanner input;
	
	public int transactBook() {
		input = new Scanner(System.in);
		System.out.println("Enter the ID of the book you want to borrow-");
		int bookID = input.nextInt();
		return bookID;
	}
}
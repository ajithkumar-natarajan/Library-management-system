package com.zoho.librarymanagementsystem;

import java.util.Scanner;

public class ReturnBook implements Transaction {
//	private BookDB transact;
	private Scanner input; //need to change
	
//	public ReturnBook() {
//		transact = new BookDB();
//	}
	public int transactBook() {
		input = new Scanner(System.in);
		System.out.println("Enter the ID of the book you want to return-");
//		transact.dispBookDB();
		int bookID = input.nextInt();
//		int quantity = transact.getQuantity(bookID);
//		System.out.println(quantity);
//		transact.transactBook(bookID, ++quantity);
		return bookID;
	}
}
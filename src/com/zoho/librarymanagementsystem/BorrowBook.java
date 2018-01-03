package com.zoho.librarymanagementsystem;

import java.util.Scanner;

public class BorrowBook implements Transaction {
//	private BookDB transact;
	private Scanner input;
	
//	public BorrowBook(){
//		transact = new BookDB();
//		input = new Scanner(System.in);
//		System.out.println("Choose the ID of the book you want to borrow-");
//		transact.dispBookDB();
//		int bookID = input.nextInt();
//		int quantity = transact.getQuantity(bookID);
//								//		if (quantity==1)
//								//			transact.deleteBook(bookID);
//								//		else
//								//			transact.transactBook(bookID, --quantity);
//		transact.transactBook(bookID, --quantity);
//		return bookID;
//	}
	
	public int transactBook() {
		input = new Scanner(System.in);
		System.out.println("Enter the ID of the book you want to borrow-");
//		transact.dispBookDB();
		int bookID = input.nextInt();
		//int quantity = transact.getQuantity(bookID);
		//transact.transactBook(bookID, --quantity);
		return bookID;
	}
}

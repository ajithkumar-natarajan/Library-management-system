package com.zoho.librarymanagementsystem;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BookDB{
	private TreeMap<Integer, Book> bookList;
	private TreeMap<Integer, Integer> bookQuantity;
	private Scanner input;
	
	public BookDB() {
		bookList = new TreeMap<Integer, Book>();
		bookQuantity = new TreeMap<Integer, Integer>();
		input = new Scanner(System.in);
	}

	public void addBook(){
		System.out.println("Enter the ID of the book:");
		int bookID = input.nextInt();
		input.nextLine();
		System.out.println("Enter the name of the book:");
		String title = input.nextLine();
		System.out.println("Enter the name of the author:");
		String author = input.nextLine();
		System.out.println("Enter the number of books available:");
		int quantity = input.nextInt();
		Book book = new Book(bookID, title, author);
		if(bookQuantity.containsKey(bookID))
		{
			int quantityAvailable = bookQuantity.get(bookID);
			int totalQuantity = quantityAvailable+quantity;
			bookQuantity.put(bookID, totalQuantity);
		}
//		else
//			bookList.put(book, 1);
		bookList.put(bookID, book);
		bookQuantity.put(bookID, quantity);
//		System.out.println(bookList);
		book.printBookDetails();
	}

	public void deleteBook(){ //sorry book not available
			System.out.println("Enter the ID of the book:");
			int bookID = input.nextInt();
			if(bookList.containsKey(bookID)) {
				bookList.remove(bookID);
				bookQuantity.remove(bookID);
			}
			else
				System.out.println("Entered book is not available in the database.");
	//		if(bookList.containsKey(book))
	//		{
	//			int quantity = bookList.get(book);
	//			if(quantity == 1)
	//				bookList.remove(book);
	//			else
	//				bookList.put(book, --quantity);
	//		}
	}
	
//	public void deleteBook(int id){ //sorry book not available
//		bookList.remove(id);
//		bookQuantity.remove(id);
//	}
	
	public void transactBook(int id, int quantity){
//		if(quantity==0)
//			bookQuantity.remove(id);
//		else
			bookQuantity.put(id, quantity);
	}
	
	public int getQuantity(int id) {
		if(bookList.containsKey(id))
			return bookQuantity.get(id);
		else
			return 0;
	}
	
	public void dispBookDB() {
		for (Map.Entry item:bookList.entrySet()){
			((Book) item.getValue()).printBookDetails();
			System.out.println("Quantity available: "+bookQuantity.get(item.getKey()));
//			System.out.println((Book)item);
		}
	}
	
//	public void dispBookDB() {
//		for (Map.Entry<Integer, Book> entry : bookList.entrySet()) {
//		     System.out.println("Key: " + entry.getKey() + ". Value: " + entry.getValue());
//		}
////		System.out.println("HI");
//	}
	
	public void dispBookDetails(int id) {
		Book book = bookList.get(id);
//		System.out.println(book);
		book.printBookDetails();
	}
}
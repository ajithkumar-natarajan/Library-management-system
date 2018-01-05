package com.zoho.librarymanagementsystem;

//import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

@SuppressWarnings("resource")

public class BookDB{
	private TreeMap<Integer, Book> bookList;
	private TreeSet<Book> bookListSort;
	private TreeMap<Integer, Integer> bookQuantity;
//	private Scanner input;
	
	public BookDB() {
		bookList = new TreeMap<Integer, Book>();
		bookListSort = new TreeSet<>(new BookSort());
		bookQuantity = new TreeMap<Integer, Integer>();
//		input = new Scanner(System.in);
	}

	public void addBook(){
		System.out.println("Enter the ID of the book:");
		Scanner input = new Scanner(System.in);
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
		bookList.put(bookID, book);
		bookListSort.add(book);
		bookQuantity.put(bookID, quantity);
//		book.printBookDetails();
		System.out.println(book);
//		System.out.println(book.hashCode());
	}

	public void deleteBook(){
			System.out.println("Enter the ID of the book:");
			Scanner input = new Scanner(System.in);
			int bookID = input.nextInt();
			if(bookList.containsKey(bookID)) {
				bookList.remove(bookID);
				bookQuantity.remove(bookID);
			}
			else
				System.out.println("Entered book is not available in the database.");
	}
	
	public void transactBook(int id, int quantity){
			bookQuantity.put(id, quantity);
	}
	
	public int getQuantity(int id) {
		if(bookList.containsKey(id))
			return bookQuantity.get(id);
		else
			return 0;
	}
	
	public void dispBookDB() {
		for (Map.Entry<Integer,Book> item:bookList.entrySet()){
//			((Book) item.getValue()).printBookDetails();
			System.out.println(item.getValue());
			System.out.println("Quantity available: "+bookQuantity.get(item.getKey()));
		}
//		for(Book b:bookListSort) { //Uncomment to sort books according to book title when printing book database
//			System.out.println(b);
//			System.out.println("Quantity available: " +bookQuantity.get(b.getID()));
//		}
	}
	
	public void dispBookDetails(int id) {
		Book book = bookList.get(id);
//		book.printBookDetails();
		System.out.println(book);
	}
	
	public Book getBookDetails(int id) {
		Book book = bookList.get(id);
		return book;
	}
}
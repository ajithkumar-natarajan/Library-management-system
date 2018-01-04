package com.zoho.librarymanagementsystem;

import java.util.LinkedList;

public class User {
	private String name, dept;
	private int id;
	protected static int returnPeriod;
	protected int numberOfBooks;
//	private LinkedList<Integer> bookList;
	private LinkedList<Book> bookList;
	
	public User(int id, String name, String dept) {
		this.id = id;
		this.name = name;
		this.dept = dept;
		bookList = new LinkedList<Book>();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}
	
//	public void borrowBook(int id) {
//		bookList.add(id);
//	}
	
	public void borrowBook(Book book) {
		bookList.add(book);
	}
	
//	public void returnBook(int id) {
//		bookList.remove(id);
//	}
	
	public void returnBook(Book book) {
		bookList.remove(book);
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getDept() {
		return this.dept;
	}
	
//	public LinkedList<Integer> getBookList(){
//		return bookList;
//	}
	
	public LinkedList<Book> getBookList(){
		return bookList;
	}
}

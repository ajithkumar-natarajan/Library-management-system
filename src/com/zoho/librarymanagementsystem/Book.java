package com.zoho.librarymanagementsystem;

public class Book {
	private int id;
	private String title, author;

	public Book(int id, String title, String author){
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public void setID(int id){
		this.id = id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public void setAuthor(String author){
		this.author = author;
	}
	
	public int getID(){
		return this.id;
	}

	public String getTitle(){
		return this.title;
	}

	public String getAuthor(){
		return this.author;
	}

	public void printBookDetails() {
		System.out.println(this.id+" : "+this.title+" by "+this.author);
		System.out.println("");
	}
	
	public static void printBookDetails(Book book) {
		System.out.println(book.id+" : "+book.title+" by "+book.author);
		System.out.println("");
	}
}
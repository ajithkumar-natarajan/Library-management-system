package com.zoho.librarymanagementsystem;

public class Staff extends User {

	public final int BOOKLIMIT;
	public static final int RETURNDURATION = 90;
	
	public Staff(int id, String name, String dept) {
		super(id, name, dept);
//		new User(id, name, dept);
		BOOKLIMIT = 6;
//		RETURNDURATION = 90;
//		returnPeriod = 90;
//		numberOfBooks = 6;
	}
	
	public static int getReturnPeriod() {
//		System.out.println(returnPeriod);
//		System.out.println(RETURNDURATION);
		return RETURNDURATION;
	}
	
//	public int getNumberOfBooks() {
//		return numberOfBooks;
//	}
}

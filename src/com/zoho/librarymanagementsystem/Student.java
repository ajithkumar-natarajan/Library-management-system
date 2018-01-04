package com.zoho.librarymanagementsystem;

public class Student extends User {
	
	public final int BOOKLIMIT;
	public static final int RETURNDURATION = 14;
	
	public Student(int id, String name, String dept) {
//		new User(id, name, dept);
		super(id, name, dept);
		BOOKLIMIT = 3;
		returnPeriod = 14;
//		numberOfBooks = 3;
	}
	
	public static int getReturnPeriod() {
//		System.out.println(returnPeriod);
		return RETURNDURATION;
	}
	
//	public int getNumberOfBooks() {
//		return numberOfBooks;
//	}
}

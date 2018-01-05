package com.zoho.librarymanagementsystem;

import java.util.*;
import java.time.LocalDate;

@SuppressWarnings("resource")

public class StaffDB {
	private TreeMap<Integer, Staff> staffData;
//	private TreeMap<Integer, LinkedList<Integer>> staffDB;
//	private TreeMap<Staff, LinkedList<Integer>> staffDB;
//	private LocalDate returnDate;
//	private Staff staff;
//	private Scanner input;
	
	public StaffDB(){
		staffData = new TreeMap<Integer, Staff>();
//		staffDB = new TreeMap<Integer, LinkedList<Integer>>();
//		staffDB = new TreeMap<Staff, LinkedList<Integer>>();
//		returnDate = LocalDate.now().plusDays(Staff.getReturnPeriod());
//		input = new Scanner(System.in);
	}
	
	public void addStaff() {
		System.out.println("Please enter the registration number:");
		Scanner input = new Scanner(System.in);
		int regNo = input.nextInt();
		input.nextLine();
		System.out.println("Please enter the name:");
		String name = input.nextLine();
		System.out.println("Please enter the department");
		String dept = input.nextLine();
		Staff staff = new Staff(regNo, name, dept);
		staffData.put(regNo, staff);
//		input.close();
	}
	
	public void removeStaff() {
		System.out.println("Please enter the registration number:");
		Scanner input = new Scanner(System.in);
		int regNo = input.nextInt();
		input.nextLine();
		System.out.println(staffData.get(regNo).getName()+" has been removed.");
//		studentData.put(regNo, student);
		staffData.remove(regNo);
//		input.close();
	}
	
	public void addBook(int regNo, Book book) {
		if(staffData.containsKey(regNo)) {
//		if(staffDB.containsKey(regNo)) {
//			LinkedList<Integer> bookIDList = staffDB.get(staffList.get(regNo));
//			LinkedList<Integer> bookIDList = staffData.get(regNo).getBookList();
//			if(bookIDList.size()<(staffData.get(regNo).BOOKLIMIT)) {
//							if(staffData.get(regNo).getBookList().size()<(staffData.get(regNo).BOOKLIMIT)) {
			if(staffData.get(regNo).getBookList().size()<(staffData.get(regNo).BOOKLIMIT)) {
//				bookIDList.add(id);
				staffData.get(regNo).borrowBook(book);
//				staffDB.put(regNo, bookIDList);
//				staffDB.put(key, value)
				LocalDate returnDate = LocalDate.now().plusDays(Staff.getReturnPeriod());
				System.out.println("Returning date for book: "+returnDate); 
			}
			else
				System.out.println("Book limit reached already");
		}
		else
//			LinkedList<Integer> bookIDList = new LinkedList<Integer>();
//			bookIDList.add(id);
//			staffDB.put(regNo, bookIDList);
//			System.out.println("Returning date for book: "+returnDate);
			System.out.println("No such user is registered. Please ask the admin to register yourself.");
	}
	
	public void removeBook(int regNo, Book book) {
		try {
			if(staffData.containsKey(regNo)) {
				if(staffData.get(regNo).getBookList().contains(book))
					staffData.get(regNo).getBookList().remove(book);
				else
					System.out.println("This book has not been borrowed by you.");
//				LinkedList<Integer> bookIDList = staffDB.get(regNo);
//				Integer rem = new Integer(id);
//				bookIDList.remove(rem);
//				staffDB.put(regNo, bookIDList);
			}
			else 
				System.out.println("No such user is registered. Please ask the admin to register yourself.");
		} catch(Exception e) {
			return;
		}
	}
	
//	public void viewBorrowedBooks(int regNo){
//		if(staffDB.containsKey(regNo)) {
//			LinkedList<Integer> list = staffDB.get(regNo);
//			 Iterator<Integer> itr=list.iterator();
//			 BookDB staffData = new BookDB();
//			 while(itr.hasNext()){
//				 staffData.dispBookDetails(itr.next());
//				 System.out.println(itr.next());
//			 }
//		}
//	}
	
	public void viewAllStaffDB(){
		for(Map.Entry<Integer, Staff> item:staffData.entrySet()){
			 System.out.println("Staff ID:" + item.getKey());
			 LinkedList<Book> list = item.getValue().getBookList();
			 Iterator<Book> itr=list.iterator();
			 while(itr.hasNext()){
//				 Book.printBookDetails(itr.next());
				 System.out.println(itr.next());
				}
		}
	}
	
	public void dispStaffBookList(int regNo) {
//		LinkedList<Integer> list = staffDB.get(regNo);
		 System.out.println("Staff ID:" + staffData.get(regNo).getID());
		 LinkedList<Book> list = staffData.get(regNo).getBookList();
		 Iterator<Book> itr=list.iterator();
		 while(itr.hasNext()){
//			 Book.printBookDetails(itr.next());
			 System.out.println(itr.next());
			}
	}
}
package com.zoho.librarymanagementsystem;

//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.Map;
//import java.util.TreeMap;

public class Library {
	private StudentDB students;
	private StaffDB staffs;
	private BookDB books;
	
	public Library() {
		students = new StudentDB();
		staffs = new StaffDB();
		books = new BookDB();
	}
	
	public void addBook() {
		books.addBook();
	}
	
	public void deleteBook() {
		books.deleteBook();
	}
	
	public void viewBookDB() {
		books.dispBookDB();
	}
	
	public void addStaff() {
		staffs.addStaff();
	}
	
	public void addStudent() {
		students.addStudent();
	}
	
	public void removeStaff() {
		staffs.removeStaff();
	}
	
	public void removeStudent() {
		students.removeStudent();
	}
	
	public void viewBookDetails(String user, int regNo) throws Exception {
		try {
			if(user == "Staff")
			{
//				LinkedList<Integer> list = staffs.getBookList(regNo);
//				System.out.println("Books taken : by "+regNo);
//				Iterator<Integer> itr=list.iterator();
//				while(itr.hasNext()){
//					books.dispBookDetails(itr.next());
//				}
				staffs.dispStaffBookList(regNo);
			}
			else
			{
//				LinkedList<Integer> list = students.getBookList(regNo);
//				System.out.println("Books taken : by "+regNo);
//				Iterator<Integer> itr=list.iterator();
//				while(itr.hasNext()){
//					books.dispBookDetails(itr.next());
//				}
				students.dispStudentBookList(regNo);
			}
		} catch(Exception e) {
			throw new Exception("No books have been taken yet!");
		}
	}
	
	public void viewStudentDB() {
//			TreeMap<Integer,LinkedList<Integer>> studentDB =  students.viewAllStudentDB();
//			for(Map.Entry<Integer, LinkedList<Integer>> item:studentDB.entrySet()){
//				 System.out.println("Student ID:" + item.getKey());
//				 LinkedList<Integer> list = item.getValue();
//				 Iterator<Integer> itr=list.iterator();
//				  while(itr.hasNext()){
//					  books.dispBookDetails(itr.next());
//				  }
//			}
		students.viewAllStudentDB();
		}
	
	public void borrowBook(String user, int regNo) {
		if(user == "Staff")
		{
			Transaction transactBook = new BorrowBook();
			int id = transactBook.transactBook();
			int quantity = books.getQuantity(id);
			books.transactBook(id, --quantity);
			staffs.addBook(regNo, books.getBookDetails(id));
		}
		else
		{
			Transaction transactBook = new BorrowBook();
			int id = transactBook.transactBook();
			int quantity = books.getQuantity(id);
			books.transactBook(id, --quantity);
			students.addBook(regNo, books.getBookDetails(id));
		}
	}
	
	public void returnBook(String user, int regNo) {
		if(user == "Staff")
		{
			Transaction transactBook = new ReturnBook();
			int id = transactBook.transactBook();
			int quantity = books.getQuantity(id);
			books.transactBook(id, ++quantity);
			staffs.removeBook(regNo, books.getBookDetails(id));
		}
		else
		{
			Transaction transactBook = new ReturnBook();
			int id = transactBook.transactBook();
			int quantity = books.getQuantity(id);
			books.transactBook(id, ++quantity);
			students.removeBook(regNo, books.getBookDetails(id));
		}
	}
	
	public void viewStaffDB() {
//		TreeMap<Integer,LinkedList<Integer>> staffDB =  staffs.viewAllStaffDB();
//		for(Map.Entry<Integer, LinkedList<Integer>> item:staffDB.entrySet()){
//			 System.out.println("Staff ID:" + item.getKey());
//			 LinkedList<Integer> list = item.getValue();
//			 Iterator<Integer> itr=list.iterator();
//			  while(itr.hasNext()){  
//				  books.dispBookDetails(itr.next());
//			  }
//		}
		staffs.viewAllStaffDB();
	}
}
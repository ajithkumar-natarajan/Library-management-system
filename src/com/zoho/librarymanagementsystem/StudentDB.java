package com.zoho.librarymanagementsystem;

import java.util.*;
import java.time.LocalDate;

@SuppressWarnings("resource")

public class StudentDB {
	private TreeMap<Integer, Student> studentData;
//	private TreeMap<Integer, LinkedList<Integer>> studentDB;
//	private TreeMap<Student, LinkedList<Integer>> studentDB;
//	private LocalDate returnDate;
//	private Student student;
//	private Scanner input;
	
	public StudentDB(){
		studentData = new TreeMap<Integer, Student>();
//		studentDB = new TreeMap<Integer, LinkedList<Integer>>();
//		studentDB = new TreeMap<Student, LinkedList<Integer>>();
//		returnDate = LocalDate.now().plusDays(Student.getReturnPeriod());
//		input = new Scanner(System.in);
	}
	
	public void addStudent() {
		System.out.println("Please enter the registration number:");
		Scanner input = new Scanner(System.in);
		int regNo = input.nextInt();
		input.nextLine();
		System.out.println("Please enter the name:");
		String name = input.nextLine();
		System.out.println("Please enter the department");
		String dept = input.nextLine();
		Student student = new Student(regNo, name, dept);
		studentData.put(regNo, student);
//		input.close();
	}
	
	public void removeStudent() {
		System.out.println("Please enter the registration number:");
		Scanner input = new Scanner(System.in);
		int regNo = input.nextInt();
		input.nextLine();
		System.out.println(studentData.get(regNo).getName()+" has been removed.");
//		studentData.put(regNo, student);
		studentData.remove(regNo);
//		input.close();
	}
	
	public void addBook(int regNo, Book book) {
		if(studentData.containsKey(regNo)) {
//		if(studentDB.containsKey(regNo)) {
//			LinkedList<Integer> bookIDList = studentDB.get(studentList.get(regNo));
//			LinkedList<Integer> bookIDList = studentData.get(regNo).getBookList();
//			if(bookIDList.size()<(studentData.get(regNo).BOOKLIMIT)) {
//							if(studentData.get(regNo).getBookList().size()<(studentData.get(regNo).BOOKLIMIT)) {
			if(studentData.get(regNo).getBookList().size()<(studentData.get(regNo).BOOKLIMIT)) {
//				bookIDList.add(id);
				studentData.get(regNo).borrowBook(book);
//				studentDB.put(regNo, bookIDList);
//				studentDB.put(key, value)
				LocalDate returnDate = LocalDate.now().plusDays(Staff.getReturnPeriod());
				System.out.println("Returning date for book: "+returnDate); 
			}
			else
				System.out.println("Book limit reached already");
		}
		else
//			LinkedList<Integer> bookIDList = new LinkedList<Integer>();
//			bookIDList.add(id);
//			studentDB.put(regNo, bookIDList);
//			System.out.println("Returning date for book: "+returnDate);
			System.out.println("No such user is registered. Please ask the admin to register yourself.");
	}
	
	public void removeBook(int regNo, Book book) {
		try {
			if(studentData.containsKey(regNo)) {
				if(studentData.get(regNo).getBookList().contains(book))
					studentData.get(regNo).getBookList().remove(book);
				else
					System.out.println("This book has not been borrowed by you.");
//				LinkedList<Integer> bookIDList = studentDB.get(regNo);
//				Integer rem = new Integer(id);
//				bookIDList.remove(rem);
//				studentDB.put(regNo, bookIDList);
			}
			else 
				System.out.println("No such user is registered. Please ask the admin to register yourself.");
		} catch(Exception e) {
			return;
		}
	}
	
//	public void viewBorrowedBooks(int regNo){
//		if(studentDB.containsKey(regNo)) {
//			LinkedList<Integer> list = studentDB.get(regNo);
//			 Iterator<Integer> itr=list.iterator();
//			 BookDB studentData = new BookDB();
//			 while(itr.hasNext()){
//				 studentData.dispBookDetails(itr.next());
//				 System.out.println(itr.next());
//			 }
//		}
//	}
	
	public void viewAllStudentDB(){
		for(Map.Entry<Integer, Student> item:studentData.entrySet()){
			 System.out.println("Student ID:" + item.getKey());
			 LinkedList<Book> list = item.getValue().getBookList();
			 Iterator<Book> itr=list.iterator();
			 while(itr.hasNext()){
				 Book.printBookDetails(itr.next());
				}
		}
	}
	
	public void dispStudentBookList(int regNo) {
//		LinkedList<Integer> list = studentDB.get(regNo);
		 System.out.println("Student ID:" + studentData.get(regNo).getID());
		 LinkedList<Book> list = studentData.get(regNo).getBookList();
		 Iterator<Book> itr=list.iterator();
		 while(itr.hasNext()){
			 Book.printBookDetails(itr.next());
			}
	}
}
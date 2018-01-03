package com.zoho.librarymanagementsystem;

import java.time.LocalDate;
import java.util.*;

public class StudentDB {
//	private TreeMap<Integer, StudentBorrowList> studentDB;
	private TreeMap<Integer, LinkedList<Integer>> studentDB;
	private BookDB studentData;
	private LocalDate returnDate;
//	private StudentBorrowList list;
	
	public StudentDB(){
//		studentDB = new TreeMap<Integer, StudentBorrowList>();
		studentDB = new TreeMap<Integer, LinkedList<Integer>>();
		studentData = new BookDB();
		returnDate = LocalDate.now().plusDays(14);
//		list = new StudentBorrowList();
	}
//	StudentBorrowList list = new StudentBorrowList();
	
	public void addBook(int regNo, int id) {
		if(studentDB.containsKey(regNo)) {
			LinkedList<Integer> bookIDList = studentDB.get(regNo);
			if(bookIDList.size()<4) {
				bookIDList.add(id);
				studentDB.put(regNo, bookIDList);
				System.out.println("Returning date for book: "+returnDate);
			}
			else
				System.out.println("Book limit reached already");
//			else //throw limit reached exception
		}
		else {
			LinkedList<Integer> bookIDList = new LinkedList<Integer>();
			bookIDList.add(id);
			studentDB.put(regNo, bookIDList);
			System.out.println("Returning date for book: "+returnDate);
		}
	}
	
	public void removeBook(int regNo, int id) {
		try {
//		if(studentDB.containsKey(regNo)) {
			LinkedList<Integer> bookIDList = studentDB.get(regNo);
			Integer rem = new Integer(id);
			bookIDList.remove(rem);
			studentDB.put(regNo, bookIDList);
		} catch(Exception e) {
			return;
		}
//		}
//		else { //must return "no such book in your database error"
//			LinkedList<Integer> bookIDList = new LinkedList<Integer>();
//			bookIDList.add(id);
//			studentDB.put(regNo, bookIDList);
//		}
	}
	
	public void viewBorrowedBooks(int regNo){
		if(studentDB.containsKey(regNo)) {
			 LinkedList<Integer> list = studentDB.get(regNo);
	//		 list.dispBorrowList(list);
			 Iterator<Integer> itr=list.iterator();
			 BookDB studentData = new BookDB();
			 while(itr.hasNext()){
				 studentData.dispBookDetails(itr.next());
	//			 itr.next().dispBookDetails();
			 }
		}
	}
	
	public TreeMap<Integer,LinkedList<Integer>> viewAllStudentDB(){
//						for(Map.Entry<Integer, LinkedList<Integer>> item:studentDB.entrySet()){
//							 System.out.println(item.getKey());
//				//			 list.dispBorrowList();
//							 
//				//			 StudentBorrowList list = (StudentBorrowList) item.getValue();
//				//			 Book list = (Book) item.getValue();
//				//			 list.dispBorrowList(list);
//				//			 list.printBookDetails();
//							 LinkedList<Integer> list = item.getValue();
//							 Iterator<Integer> itr=list.iterator();  
//							  while(itr.hasNext()){  
//								  studentData.dispBookDetails(itr.next());
//				//				  System.out.println(itr.next());  
//							  }
//						}
		return studentDB;
	}
	
	public LinkedList<Integer> getBookList(int regNo) {
//		if(staffDB.containsKey(regNo)) {
			LinkedList<Integer> list = studentDB.get(regNo);
	//		 list.dispBorrowList(list);
			return list;
//			Iterator<Integer> itr=list.iterator();
//			BookDB staffData = new BookDB();
//			while(itr.hasNext()){
//				 staffData.dispBookDetails(itr.next());
//				 System.out.println(itr.next());
//	//			 itr.next().dispBookDetails();
//			}
		}
}
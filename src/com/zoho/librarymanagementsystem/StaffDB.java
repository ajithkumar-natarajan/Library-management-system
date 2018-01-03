package com.zoho.librarymanagementsystem;

import java.util.*;
import java.time.LocalDate;

public class StaffDB {
//	private TreeMap<Integer, StaffBorrowList> staffDB;
	private TreeMap<Integer, LinkedList<Integer>> staffDB;
	private BookDB staffData;
	private LocalDate returnDate;
//	private StaffBorrowList list;
	
	public StaffDB(){
//		staffDB = new TreeMap<Integer, StaffBorrowList>();
		staffDB = new TreeMap<Integer, LinkedList<Integer>>();
		staffData = new BookDB();
		returnDate = LocalDate.now().plusDays(90);
//		list = new StaffBorrowList();
	}
//	StaffBorrowList list = new StaffBorrowList();
	
	public void addBook(int regNo, int id) {
		if(staffDB.containsKey(regNo)) {
			LinkedList<Integer> bookIDList = staffDB.get(regNo);
			if(bookIDList.size()<6) {
				bookIDList.add(id);
				staffDB.put(regNo, bookIDList);
				System.out.println("Returning date for book: "+returnDate); 
			}
			else
				System.out.println("Book limit reached already");
//			for (Map.Entry item:staffDB.entrySet()){
//				System.out.println("in if "+item.getValue());
//			}
//			else //throw limit reached exception
		}
		else {
			LinkedList<Integer> bookIDList = new LinkedList<Integer>();
			bookIDList.add(id);
			staffDB.put(regNo, bookIDList);
			System.out.println("Returning date for book: "+returnDate);
//			for (Map.Entry item:staffDB.entrySet()){
//				System.out.println(item.getValue());
//				System.out.println((Book)item);
//			}
		}
	}
	
	public void removeBook(int regNo, int id) {
//		if(staffDB.containsKey(regNo)) {
		try {
			LinkedList<Integer> bookIDList = staffDB.get(regNo);
//			System.out.println("in iff "+bookIDList);
//			System.out.println(id);
			Integer rem = new Integer(id);
			bookIDList.remove(rem);
			staffDB.put(regNo, bookIDList);
		} catch(Exception e) {
			return;
		}
//		}
//		else { //must return "no such book in your database error"
//			LinkedList<Integer> bookIDList = new LinkedList<Integer>();
//			bookIDList.add(id);
//			staffDB.put(regNo, bookIDList);
//		}
	}
	
	public void viewBorrowedBooks(int regNo){
		if(staffDB.containsKey(regNo)) {
			LinkedList<Integer> list = staffDB.get(regNo);
	//		 list.dispBorrowList(list);
			 Iterator<Integer> itr=list.iterator();
			 BookDB staffData = new BookDB();
			 while(itr.hasNext()){
				 staffData.dispBookDetails(itr.next());
				 System.out.println(itr.next());
	//			 itr.next().dispBookDetails();
			 }
		}
	}
	
	public TreeMap<Integer,LinkedList<Integer>> viewAllStaffDB(){
//							for(Map.Entry<Integer, LinkedList<Integer>> item:staffDB.entrySet()){
//								 System.out.println(item.getKey());
//					//			 list.dispBorrowList();
//								 
//					//			 StudentBorrowList list = (StudentBorrowList) item.getValue();
//					//			 Book list = (Book) item.getValue();
//					//			 list.dispBorrowList(list);
//					//			 list.printBookDetails();
//								 LinkedList<Integer> list = item.getValue();
//								 Iterator<Integer> itr=list.iterator();  
//								  while(itr.hasNext()){  
//									  staffData.dispBookDetails(itr.next());
//					//				  System.out.println(itr.next());  
//								  }
//							}
		return staffDB;
	}
	
	public LinkedList<Integer> getBookList(int regNo) {
//		if(staffDB.containsKey(regNo)) {
			LinkedList<Integer> list = staffDB.get(regNo);
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
//}
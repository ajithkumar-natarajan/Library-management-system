package com.zoho.librarymanagementsystem;

import java.util.Comparator;

public class BookSort implements Comparator<Book> {
	@Override
	public int compare(Book b1, Book b2) {
		return b1.getTitle().compareToIgnoreCase(b2.getTitle());
	}
}

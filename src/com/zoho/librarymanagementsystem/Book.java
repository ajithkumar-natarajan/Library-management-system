package com.zoho.librarymanagementsystem;

public class Book implements Cloneable {
	private int id;
	private String title, author;
	
	public Object clone()throws CloneNotSupportedException{  
		return super.clone();  
	}
	
//	public int hashCode() {
//		return this.id+this.title.hashCode()+this.author.hashCode();
//	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
//	public boolean equals(Book obj) {
//	    return (this.hashCode() == obj.hashCode());
//	}
//	 @Override
//	public boolean equals(Object obj) {
//		System.out.println("-----");
//		if(obj==this)
//			return true;
//		if(obj instanceof Book && this.hashCode() == obj.hashCode())
//			return ((this.id == ((Book) obj).id))&&(this.title.equals(((Book)obj).title)&&(this.author.equals(((Book)obj).author)));
//		return false;
//	}

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

//	public void printBookDetails() {
//		System.out.println(this.id+" : "+this.title+" by "+this.author);
//		System.out.println("");
//	}
	
	public String toString() {
		return this.id+" : "+this.title+" by "+this.author;
	}
	
//	public static void printBookDetails(Book book) {
//		System.out.println(book.id+" : "+book.title+" by "+book.author);
//		System.out.println("");
//	}
	
	public String toString(Book book) {
		return book.id+" : "+book.title+" by "+book.author;
	}
}
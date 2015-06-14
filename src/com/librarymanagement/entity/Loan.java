package com.librarymanagement.entity;

import java.sql.Date;

public class Loan {
	private int id;
	private int memberId;
	private int bookId;
	private Date returnDate;

	public Loan(int id, int memberId, int bookId, Date returnDate){
		this.id = id;
		this.memberId = memberId;
		this.bookId = bookId;
		this.returnDate = returnDate;
	}
	
	public int id(){
		return id;
	}
	
	public int memberId(){
		return memberId;
	}
	public int bookId(){
		return bookId;
	}
	public Date returnDate(){
		return returnDate;
	}
	
	public void display(){
		System.out.println(id);
		System.out.println(memberId);
		System.out.println(bookId);
		System.out.println(returnDate);
	}
}

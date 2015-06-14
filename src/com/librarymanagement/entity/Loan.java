package com.librarymanagement.entity;

import java.sql.Date;

public class Loan {
	private int id;
	private int memberId;
	private Date returnDate;

	public Loan(int id, int memberId, Date returnDate){
		this.id = id;
		this.memberId = memberId;
		this.returnDate = returnDate;
	}
	
	public int id(){
		return id;
	}
	
	public int memberId(){
		return memberId;
	}
	public Date returnDate(){
		return returnDate;
	}
}

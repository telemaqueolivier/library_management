package com.librarymanagement.entity;

public class Member {
	private int id = 0;
	private String firstName = "";
	private String lastName = "";
	private String postalAddress = "";
	private String email = "";
	private String job = "";
	
	public Member(){
		
	}
	
	public Member(int id, String firstName, String lastName, String postalAddress, String email, String job){
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.postalAddress = postalAddress;
		this.email = email;
		this.job = job;
	}
	
	public String FirstName(){
		return firstName;
	}
	
	public String LastName(){
		return lastName;
	}
	
	public String PostalAddress(){
		return postalAddress;
	}
	public String Email(){
		return email;
	}
	
	public String Job(){
		return job;
	}
	
	public void display(){
		System.out.println(id);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(postalAddress);
		System.out.println(email);
		System.out.println(job);
	}
}

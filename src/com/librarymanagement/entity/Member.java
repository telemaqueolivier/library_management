package com.librarymanagement.entity;

public class Member {
	private int id = 0;
	private String firstName = "";
	private String lastName = "";
	private String postalAddress = "";
	private String email = "";
	private String job = "";

	public Member() {

	}

	public Member(int id, String firstName, String lastName,
			String postalAddress, String email, String job) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.postalAddress = postalAddress;
		this.email = email;
		this.job = job;
	}

	public int id() {
		return id;
	}

	public String firstName() {
		return firstName;
	}

	public String lastName() {
		return lastName;
	}

	public String postalAddress() {
		return postalAddress;
	}

	public String email() {
		return email;
	}

	public String job() {
		return job;
	}

	public void display() {
		System.out.format("%-15s", "first name");
		System.out.format("%-15s", "last name");
		System.out.format("%-30s", "postal address");
		System.out.format("%-30s", "email");
		System.out.format("%-15s", "job");
		System.out.println();
		System.out.format("%-15s", firstName);
		System.out.format("%-15s", lastName);
		System.out.format("%-30s", postalAddress);
		System.out.format("%-30s", email);
		System.out.format("%-15s", job);
		System.out.println();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Member other = (Member) obj;
		if (id != other.id)
			return false;
		
		System.out.println("equal");
		return true;
	}
}

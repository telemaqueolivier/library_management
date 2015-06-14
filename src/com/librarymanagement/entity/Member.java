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
		System.out.println(id);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(postalAddress);
		System.out.println(email);
		System.out.println(job);
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

package com.librarymanagement.entity;

public class Book {
	private int id;
	private String title;
	private String author;
	private String code;
	private int totalCopyNum;
	private int availableCopyNum;
	
	public Book(int id, String title, String author, String code, int totalCopyNum, int availableCopyNum){
		this.id = id;
		this.title = title;
		this.author = author;
		this.code = code;
		this.totalCopyNum = totalCopyNum;
		this.availableCopyNum = availableCopyNum;
	}
	public int id(){
		return id;
	}
	public String title() {
		return title;
	}
	public String author() {
		return author;
	}
	public String code() {
		return code;
	}
	public int totalCopyNum() {
		return totalCopyNum;
	}
	public int availableCopyNum() {
		return availableCopyNum;
	}
	public void display(){
		System.out.println(id);
		System.out.println(title);
		System.out.println(author);
		System.out.println(code);
		System.out.println(totalCopyNum);
		System.out.println(availableCopyNum);
	}
}

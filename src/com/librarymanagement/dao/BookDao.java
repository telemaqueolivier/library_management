package com.librarymanagement.dao;

import java.sql.Connection;

import com.librarymanagement.entity.Book;

public abstract class BookDao extends Dao<Book> {

	public BookDao(Connection connection, String tableName) {
		super(connection, tableName);
	}
	
	public abstract boolean updateAvailableCopyNum(int id, int availableCopyNum);
}

package com.librarymanagement.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.librarymanagement.entity.Book;
import com.librarymanagement.entity.Member;

public class BookDao extends Dao<Book> {

	public BookDao(Connection connection) {
		super(connection, "Book");
	}

	@Override
	public Book find(int id) {
		Book book = null;

		try {
			ResultSet result = this.connection.prepareStatement(
					"SELECT * FROM Book WHERE id = " + id,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery();
			if (result.first())
				book = new Book(id, result.getString("title"),
						result.getString("author"), result.getString("code"),
						result.getInt("total_copy_num"),
						result.getInt("available_copy_num"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public boolean create(Book entity) {
		boolean ret;
		try {
			this.connection
					.prepareStatement(
							"INSERT INTO Book (title, author, code,  total_copy_num, available_copy_num) VALUES ('"
									+ entity.title()
									+ "','"
									+ entity.author()
									+ "','"
									+ entity.code()
									+ "','"
									+ String.valueOf(entity.totalCopyNum())
									+ "','"
									+ String.valueOf(entity.availableCopyNum())
									+ "')").executeUpdate();
			ret = true;
		} catch (SQLException e) {
			e.printStackTrace();
			ret = false;
		}
		return ret;
	}

	public boolean updateAvailableCopyNum(int id, int availableCopyNum) {
		boolean ret;
		try {
			this.connection
					.prepareStatement(
							"UPDATE Book SET available_copy_num='"
									+ String.valueOf(availableCopyNum)
									+ "' WHERE id='" + String.valueOf(id) + "'").executeUpdate();
			ret = true;
		} catch (SQLException e) {
			e.printStackTrace();
			ret = false;
		}
		return ret;
	}

	@Override
	public boolean update(Book entity) {
		// TODO Auto-generated method stub
		return false;
	}
}

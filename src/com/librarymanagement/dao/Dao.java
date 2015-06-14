package com.librarymanagement.dao;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class Dao<T> {
	protected Connection connection = null;
	protected String tableName;

	public Dao(Connection connection, String tableName) {
		this.connection = connection;
		this.tableName = tableName;
	}

	public abstract T find(int id);

	public abstract boolean create(T entity);

	public abstract boolean update(T entity);

	public boolean delete(int id) {
		boolean ret;
		try {
			this.connection.prepareStatement(
					"DELETE FROM " + tableName + " WHERE id='" + id + "'")
					.executeUpdate();
			ret = true;
		} catch (SQLException e) {
			e.printStackTrace();
			ret = false;
		}
		return ret;
	}
}

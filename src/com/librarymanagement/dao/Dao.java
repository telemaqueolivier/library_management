package com.librarymanagement.dao;

import java.sql.Connection;

public abstract class Dao<T> {
	protected Connection connection = null;
	   
	  public Dao(Connection connection){
	    this.connection = connection;
	  }
	public abstract T find(int id);
	public abstract boolean create(T entity);
	public abstract boolean update(T entity);
	public abstract boolean delete(T entity);
}

package com.librarymanagement.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LibraryManagementConnection {
	private String url = "jdbc:mysql://localhost:3306/DbLibraryManagement";
	private String user = "library";
	private String passwd = "library";
	private static Connection connection;

	private LibraryManagementConnection() {
		try {
			connection = DriverManager.getConnection(url, user, passwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getInstance() {
		if (connection == null) {
			new LibraryManagementConnection();
		}
		return connection;
	}
}

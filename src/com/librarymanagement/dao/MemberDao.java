package com.librarymanagement.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.librarymanagement.entity.Member;

public class MemberDao extends Dao<Member> {

	public MemberDao(Connection connection) {
		super(connection);
	}

	@Override
	public Member find(int id) {
		Member member = null;

		try {
			ResultSet result = this.connection.prepareStatement(
					"SELECT * FROM Member WHERE id = " + id,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery();
			if (result.first())
				member = new Member(id, result.getString("first_name"),
						result.getString("last_name"),
						result.getString("postal_address"),
						result.getString("mail_address"),
						result.getString("job"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public boolean create(Member entity) {
		boolean ret;
		try {
			this.connection
					.prepareStatement(
							"INSERT INTO Member (first_name, last_name, postal_address, mail_address, job) VALUES ('"
									+ entity.FirstName()
									+ "','"
									+ entity.LastName()
									+ "','"
									+ entity.PostalAddress()
									+ "','"
									+ entity.Email()
									+ "','"
									+ entity.Job()
									+ "')").executeUpdate();
			ret = true;
		} catch (SQLException e) {
			e.printStackTrace();
			ret = false;
		}
		return ret;
	}

	@Override
	public boolean update(Member entity) {
		return false;
	}

	@Override
	public boolean delete(Member entity) {
		// TODO Auto-generated method stub
		boolean ret;
		try {
			this.connection.prepareStatement(
					"DELETE FROM Member WHERE first_name='"
							+ entity.FirstName() + "' AND last_name='"
							+ entity.LastName() + "' AND postal_address='"
							+ entity.PostalAddress() + "' AND mail_address='"
							+ entity.Email() + "' AND job='" + entity.Job()
							+ "'").executeUpdate();
			ret = true;
		} catch (SQLException e) {
			e.printStackTrace();
			ret = false;
		}
		return ret;
	}

}

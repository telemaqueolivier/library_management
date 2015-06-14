package com.librarymanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.librarymanagement.entity.Member;

public class MemberDaoImpl extends MemberDao {
	public MemberDaoImpl(Connection connection) {
		super(connection, "Member");
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
									+ entity.firstName()
									+ "','"
									+ entity.lastName()
									+ "','"
									+ entity.postalAddress()
									+ "','"
									+ entity.email()
									+ "','"
									+ entity.job()
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
	public ArrayList<Member> findAllMembers() {
		ArrayList<Member> members = null;

		try {
			ResultSet result = this.connection.prepareStatement(
					"SELECT * FROM Member", ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery();
			members = new ArrayList<Member>();
			while (result.next()) {
				Member member = new Member(result.getInt("id"),
						result.getString("first_name"),
						result.getString("last_name"),
						result.getString("postal_address"),
						result.getString("mail_address"),
						result.getString("job"));
				members.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return members;
	}

}

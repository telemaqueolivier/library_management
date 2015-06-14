package com.librarymanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.librarymanagement.entity.Member;

public abstract class MemberDao extends Dao<Member> {

	public MemberDao(Connection connection, String tableName) {
		super(connection, tableName);
	}
    public abstract ArrayList<Member> findAllMembers();
}

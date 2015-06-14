package com.librarymanagement.dao;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;

import com.librarymanagement.entity.Loan;

public abstract class LoanDao extends Dao<Loan> {

	public LoanDao(Connection connection, String tableName) {
		super(connection, tableName);
	}
	public abstract ArrayList<Loan> findAllLoansByMemberId(int memberId);
	public abstract boolean deleteLoan(Loan loan);
	public abstract ArrayList<Loan> findAllLoansByReturnDateLowerThanCurrentTime();
}

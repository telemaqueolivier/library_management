package com.librarymanagement.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.librarymanagement.entity.Book;
import com.librarymanagement.entity.Loan;

public class LoanDao extends Dao<Loan> {

	public LoanDao(Connection connection) {
		super(connection, "Loan");
	}

	@Override
	public Loan find(int id) {
		return null;
	}

	@Override
	public boolean create(Loan entity) {
		boolean ret;
		try {
			this.connection
					.prepareStatement(
							"INSERT INTO Loan (member_id, return_date) VALUES ('"
									+ String.valueOf(entity.memberId())
									+ "','"
									+ entity.returnDate().toString()
									+ "')").executeUpdate();
			ret = true;
		} catch (SQLException e) {
			e.printStackTrace();
			ret = false;
		}
		return ret;
	}
	
	@Override
	public boolean update(Loan entity) {
		return false;
	}

	public ArrayList<Loan> getAllLoansByMemberId(int memberId){
		ArrayList<Loan> loansList = null;

		try {
			ResultSet result = this.connection.prepareStatement(
					"SELECT * FROM Loan WHERE member_id = " + memberId,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery();
			loansList = new ArrayList<Loan>();
			while(result.next()){
				Loan loan = new Loan(result.getInt("id"), memberId, result.getDate("return_date"));
				loansList.add(loan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loansList;
	}
}

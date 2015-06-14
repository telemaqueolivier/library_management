package com.librarymanagement.service;

import java.util.ArrayList;
import java.sql.Date;

import com.librarymanagement.connection.LibraryManagementConnection;
import com.librarymanagement.dao.BookDao;
import com.librarymanagement.dao.Dao;
import com.librarymanagement.dao.LoanDao;
import com.librarymanagement.dao.MemberDao;
import com.librarymanagement.entity.Book;
import com.librarymanagement.entity.Loan;
import com.librarymanagement.entity.Member;

public class LoanService {
	LoanDao loanDao = new LoanDao(LibraryManagementConnection.getInstance());
	BookDao bookDao = new BookDao(LibraryManagementConnection.getInstance());
	
	public boolean loanBook(Member member, Book book, Date returnDate){
		boolean ret = false;
		ArrayList<Loan> loans = loanDao.getAllLoansByMemberId(member.id());
		
		if(loans.size() < 3){
			if (book.availableCopyNum() > 0){
				Loan loan = new Loan(0, member.id(), returnDate);
				loanDao.create(loan);
				bookDao.updateAvailableCopyNum(book.id(), book.availableCopyNum() - 1);
				ret = true;
			}
		}
		
		return ret;
	}

}

package com.librarymanagement.service;

import java.util.ArrayList;
import java.sql.Date;

import com.librarymanagement.connection.LibraryManagementConnection;
import com.librarymanagement.dao.BookDao;
import com.librarymanagement.dao.BookDaoImpl;
import com.librarymanagement.dao.LoanDao;
import com.librarymanagement.dao.LoanDaoImpl;
import com.librarymanagement.entity.Book;
import com.librarymanagement.entity.Loan;
import com.librarymanagement.entity.Member;

public class LoanService {
	LoanDao loanDao = new LoanDaoImpl(LibraryManagementConnection.getInstance());
	BookDao bookDao = new BookDaoImpl(LibraryManagementConnection.getInstance());
	
	public boolean loanBook(Member member, Book book, Date returnDate){
		boolean ret = false;
		ArrayList<Loan> loans = loanDao.findAllLoansByMemberId(member.id());

		if(loans.size() < 3){
			if (book.availableCopyNum() > 0){
				Loan loan = new Loan(0, member.id(), book.id(), returnDate);
				loanDao.create(loan);
				bookDao.updateAvailableCopyNum(book.id(), book.availableCopyNum() - 1);
				ret = true;
			}
		}
		
		return ret;
	}

	public boolean restituteBook(Member member, Book book, Date returnDate){
		boolean ret = false;
		
		if(bookDao.updateAvailableCopyNum(book.id(), book.availableCopyNum() + 1)){
			if(loanDao.deleteLoan(new Loan(0, member.id(), book.id(), returnDate))){
				ret = true;
			}
		}
		
		return ret;
	}
}

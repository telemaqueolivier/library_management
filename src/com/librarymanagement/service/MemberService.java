package com.librarymanagement.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import javax.rmi.CORBA.UtilDelegate;

import com.librarymanagement.connection.LibraryManagementConnection;
import com.librarymanagement.dao.LoanDao;
import com.librarymanagement.dao.LoanDaoImpl;
import com.librarymanagement.dao.MemberDao;
import com.librarymanagement.dao.MemberDaoImpl;
import com.librarymanagement.entity.Loan;
import com.librarymanagement.entity.Member;

public class MemberService {
	MemberDao memberDao = new MemberDaoImpl(LibraryManagementConnection.getInstance());
	LoanDao loanDao = new LoanDaoImpl(LibraryManagementConnection.getInstance());
	
	public ArrayList<Member> getAllMembersSortedByName(){
		ArrayList<Member> members = memberDao.findAllMembers();
		
		Collections.sort(members, new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				int ret = o1.lastName().compareTo(o2.lastName());
				if(ret == 0){
					ret = o1.firstName().compareTo(o2.firstName());
				}
				
				return ret;
			}
		});
		
		return members;
	}

	public HashSet<Member> getAllMembersByBookReturnDateExceeded(){
		ArrayList<Loan> loans = loanDao.findAllLoansByReturnDateLowerThanCurrentTime();
		HashSet<Member> members = null;
		
		if(loans != null && loans.size() > 0){
			members = new HashSet<Member>();
			
			for(Loan loan : loans){
				members.add(memberDao.find(loan.memberId()));
			}
		}
		
		return members;
	}
}

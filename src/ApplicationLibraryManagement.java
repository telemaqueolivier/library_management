import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.librarymanagement.connection.LibraryManagementConnection;
import com.librarymanagement.dao.BookDao;
import com.librarymanagement.dao.BookDaoImpl;
import com.librarymanagement.dao.LoanDao;
import com.librarymanagement.dao.LoanDaoImpl;
import com.librarymanagement.dao.MemberDao;
import com.librarymanagement.dao.MemberDaoImpl;
import com.librarymanagement.entity.Book;
import com.librarymanagement.entity.Loan;
import com.librarymanagement.entity.Member;
import com.librarymanagement.service.LoanService;
import com.librarymanagement.service.MemberService;
import com.librarymanagement.userinterface.Viewer;
import com.librarymanagement.userinterface.ViewerManager;

public class ApplicationLibraryManagement {

	public static void main(String[] args) {
//		MemberDao DaoMember = new MemberDaoImpl(
//				LibraryManagementConnection.getInstance());
//		Member member = DaoMember.find(1);
//		member.display();
//
//		Member member2 = new Member(0, "Lea", "Femen",
//				"7 rue des Groux, 92140 Clamart", "lea.Femen@gmail.com",
//				"biologist");
//		boolean ret = false;
////		ret = DaoMember.create(member2);
//		// ret = DaoMember.delete(member2);
////		System.out.println(ret);
//
//		BookDao bookDao = new BookDaoImpl(
//				LibraryManagementConnection.getInstance());
////		Book book = new Book(0, "titre3", "author3", "ROM-002", 21, 21);
//		Book book = bookDao.find(1);
//		
//		LoanService loanService = new LoanService();
//		loanService.loanBook(member, book, new Date(2015, 7, 5));
//		
//		book = bookDao.find(1); // call find again in order to update book entity
//		loanService.restituteBook(member, book, new Date(2015, 7, 5));
//		//		ret = bookDao.create(book);
////		System.out.println(ret);
//
////		book = bookDao.find(7);
////		if (book != null) {
////			book.display();
////			ret = bookDao.delete(8);
////		}
//		
//		ArrayList<Member> members = DaoMember.findAllMembers();
//		for (Member m : members){
//			m.display();
//		}
//		
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println("sorted");
//		MemberService memberService = new MemberService();
//		members = memberService.getAllMembersSortedByName();
//		for (Member m : members){
//			m.display();
//		}
//		
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println("loans by date lower than now");
//		LoanDao loanDao = new LoanDaoImpl(LibraryManagementConnection.getInstance());
//		ArrayList<Loan> loans = loanDao.findAllLoansByReturnDateLowerThanCurrentTime();
//		for (Loan l : loans){
//			l.display();
//		}
//		
//		
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		System.out.println("all members not having restituted their loans");
//		HashSet<Member> membersSet = memberService.getAllMembersByBookReturnDateExceeded();
//		for (Member m : membersSet){
//			m.display();
//		}
//		System.out.println(ret);

		
		Viewer view = new ViewerManager();
		view.start();
		
		System.out.println("hello");
	}

}

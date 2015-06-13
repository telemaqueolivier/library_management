import com.librarymanagement.connection.LibraryManagementConnection;
import com.librarymanagement.dao.Dao;
import com.librarymanagement.dao.MemberDao;
import com.librarymanagement.entity.Member;


public class ApplicationLibraryManagement {

	public static void main(String[] args) {
		Dao<Member> DaoMember = new MemberDao(LibraryManagementConnection.getInstance());
		Member member = DaoMember.find(1);
		member.display();
		
		Member member2 = new Member(0, "Lea", "Femen", "7 rue des Groux, 92140 Clamart", "lea.Femen@gmail.com", "biologist");
		boolean ret = false;
		ret = DaoMember.create(member2);
		ret = DaoMember.delete(member2);
		System.out.println(ret);
		System.out.println("hello");
	}

}

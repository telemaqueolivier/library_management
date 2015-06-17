package com.librarymanagement.userinterface;

import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

import com.librarymanagement.entity.Member;
import com.librarymanagement.service.MemberService;

public class ServiceViewer extends Viewer {
	MemberService memberService = new MemberService();

	private void displayFunctionalities() {
		System.out.println("0. list member");
		System.out.println("1. list member with loan date exceeded");
		System.out.println("2. quit");
	}

	private void displayAllMembersSortedByName(){
		ArrayList<Member> members = memberService.getAllMembersSortedByName();
		
		System.out.format("%-15s", "first name");
		System.out.format("%-15s", "last name");
		System.out.format("%-40s", "postal address");
		System.out.format("%-30s", "email");
		System.out.format("%-15s", "job");
		System.out.println();
		
		for(Member m : members){
			System.out.format("%-15s", m.firstName());
			System.out.format("%-15s", m.lastName());
			System.out.format("%-40s", m.postalAddress());
			System.out.format("%-30s", m.email());
			System.out.format("%-15s", m.job());
			System.out.println();
		}
	}
	
	@Override
	protected void interact() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			do {
				displayFunctionalities();
				choice = sc.nextInt();

			} while (choice < 0 || choice > 2);

			switch (choice) {
			case 0:
				
				break;
				
			case 1:
				displayAllMembersSortedByName();
				break;
			
			default:
				break;
			}
			
		} while (choice != 2);
	}
}

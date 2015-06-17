package com.librarymanagement.userinterface;

import java.util.Scanner;

public class ViewerManager extends Viewer {
	private Viewer viewers[] = {new ServiceViewer()};

	private void displayFunctionalities() {
		// TODO Auto-generated method stub
		System.out.println("0. service menu");
		System.out.println("1. librarian menu");
		System.out.println("2. quit");
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

			if (choice >= 0 && choice <= 1) {
				viewers[choice].start();
			}
		} while (choice != 2);
	}

	@Override
	public void start() {
		interact();
	}
}

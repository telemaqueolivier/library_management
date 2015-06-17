package com.librarymanagement.userinterface;

public abstract class Viewer {
	protected abstract void interact();
	public void start() {
		interact();
	}
}

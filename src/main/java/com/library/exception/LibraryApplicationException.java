package com.library.exception;

public class LibraryApplicationException extends RuntimeException{

	
	public LibraryApplicationException(Exception e) {
		super(e);
	}
	
	public LibraryApplicationException(String message) {
		super(message);
	}
	
	
	public LibraryApplicationException(String message, Exception e) {
		super(message, e);
	}
	
}

package com.library.dto;

import java.util.ArrayList;
import java.util.List;

public class Books {

	private List<Book> books = new ArrayList<Book>();

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	
		
}

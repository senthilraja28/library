package com.library.service;

import com.library.dto.Book;
import com.library.dto.Books;

public interface BookService {

	public Books getBooks();
	public Book getBookById(Long bookId);
	public Book saveBook(Book book);
	public Book updateBook(Book book, Long bookId);
	public boolean deleteBook(Long bookId);
	
	
}

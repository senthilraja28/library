package com.library.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dto.Book;
import com.library.dto.Books;
import com.library.exception.ResourceNotFoundException;
import com.library.jpa.BookJpa;
import com.library.jpa.BookJpaBuilder;
import com.library.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookJpaBuilder bookJpaBuilder;
	
	@Override
	public Books getBooks() {
		Iterable<BookJpa> booksItr = bookRepository.findAll();
		
		Books books = new Books();
		
		
		for(BookJpa bookJpa : booksItr) {
			Book book = new Book();
			book.setBookId(bookJpa.getId());
			book.setBookName(bookJpa.getBookName());
			book.setLibraryId(bookJpa.getLibrary().getId());
			book.setAuthors(bookJpa.getAuthors());
			book.setPublicationName(bookJpa.getPublicationName());
			
			if(bookJpa.getPublitionDate() != null) {
				book.setPublishDate(bookJpa.getPublitionDate());
			}
			else {
				book.setPublishDate(new Date());
			}
			
			books.addBook(book);
		}
		
		return books;
		
		
	}

	@Override
	public Book getBookById(Long bookId) {
		// TODO Auto-generated method stub
		
		Optional<BookJpa> optionalBookJap = bookRepository.findById(bookId);
		
		if(optionalBookJap.isPresent()) {
			throw new ResourceNotFoundException("No book available with id " + bookId);
		}
		
		BookJpa bookJpa = optionalBookJap.get();
		Book book = new Book();
		book.setBookId(bookJpa.getId());
		book.setBookName(bookJpa.getBookName());
		book.setLibraryId(bookJpa.getLibrary().getId());
		book.setAuthors(bookJpa.getAuthors());
		book.setPublicationName(bookJpa.getPublicationName());
		
		if(bookJpa.getPublitionDate() != null) {
			book.setPublishDate(bookJpa.getPublitionDate());
		}
		else {
			book.setPublishDate(new Date());
		}
		
		return book;

	}

	@Override
	public Book saveBook(Book book) {
		
		System.out.println(book);
		
		BookJpa temp = bookRepository.save(bookJpaBuilder.buildBookJpa(book));
		
		book.setBookId(temp.getId());
		
		return book;
	}

	@Override
	public Book updateBook(Book book, Long bookId) {
		book.setBookId(bookId);
		
		
		Optional<BookJpa> bookJpaDb = bookRepository.findById(bookId);
		
		if(!bookJpaDb.isPresent()) {
			throw new ResourceNotFoundException("Book not found with id: " + bookId);
		}
		
		bookRepository.save(bookJpaBuilder.buildBookJpa(bookJpaDb.get(), book));
		return book;
	}

	@Override
	public boolean deleteBook(Long bookId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}

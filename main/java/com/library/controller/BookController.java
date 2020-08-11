package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.dto.Book;
import com.library.dto.Books;
import com.library.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/library")
public class BookController {
	
	private final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookService;

	@PostMapping("/books")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		logger.info("Recevied Save Book Request: " + book.getBookName());
		Book bookResult = bookService.saveBook(book);	
		
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
		return responseEntity;
	}
	
	@PutMapping("/books/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("id") Long bookId) {
		logger.info("Recevied Update Book Request: " + book.getBookName() + ", BookId: " + bookId);
		Book bookResult = bookService.updateBook(book, bookId);		
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
		return responseEntity;
	}
	
	@GetMapping("/books")
	public Books getBooks() {
		return bookService.getBooks();
	}
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable("id") Long bookId) {
		return null;
	}
	
}

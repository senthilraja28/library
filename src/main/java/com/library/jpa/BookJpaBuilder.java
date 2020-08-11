package com.library.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.dto.Book;
import com.library.exception.LibraryApplicationException;
import com.library.exception.ResourceNotFoundException;
import com.library.repository.LibraryRepository;

import java.util.Optional;

@Component
public class BookJpaBuilder {

	@Autowired
	private LibraryRepository libraryRepository;
	
	BookJpa bookJpa = null;
	
	
	public BookJpa buildBookJpa(Book book) {
		
		BookJpa bookJpa = new BookJpa();
		
		if(book.getBookId() != null) {
			bookJpa.setId(book.getBookId());
		}
		
		bookJpa.setBookName(book.getBookName());
		bookJpa.setAuthors(book.getAuthors());
		bookJpa.setPublicationName(book.getPublicationName());
		bookJpa.setPublitionDate(book.getPublishDate());
		
		Optional<LibraryJpa> libraryJpa = libraryRepository.findById(book.getLibraryId());
		
		if(!libraryJpa.isPresent()) {
			throw new ResourceNotFoundException("No Library Data found");
		}
		
		bookJpa.setLibrary(libraryJpa.get());
		
		return bookJpa;
		
	}
	
	public BookJpa buildBookJpa(final BookJpa bookJpaDb, Book book) {
		
		
		BookJpa bookJpa;
		try {
			bookJpa = (BookJpa) bookJpaDb.clone();
		} catch (CloneNotSupportedException e) {
			throw new LibraryApplicationException(e.getMessage(), e);
		}

		if(book.getBookName() != null) {
			bookJpa.setBookName(book.getBookName());
		}
		
		if(book.getAuthors() != null) {
			bookJpa.setAuthors(book.getAuthors());
		}
		
		if(book.getPublicationName() != null) {
			bookJpa.setPublicationName(book.getPublicationName());
		}
		
		if(book.getPublishDate() != null) {
			bookJpa.setPublitionDate(book.getPublishDate());
		}
		
		if(book.getLibraryId() != null) {
			Optional<LibraryJpa> libraryJpa = libraryRepository.findById(book.getLibraryId());
			
			if(!libraryJpa.isPresent()) {
				throw new ResourceNotFoundException("No Library Data found");
			}
			
			bookJpa.setLibrary(libraryJpa.get());
		}
			
		return bookJpa;
		
	}
	
	
}

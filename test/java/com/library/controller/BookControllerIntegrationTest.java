package com.library.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.library.LibraryBootApplication;
import com.library.dto.Book;
import com.library.dto.Books;


@SpringBootTest(classes = LibraryBootApplication.class, 
webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookControllerIntegrationTest {

	@LocalServerPort
    private int port;
 
    @Autowired
    private TestRestTemplate restTemplate;
    
    
    @Test
    public void testAllBooks() 
    {
        assertTrue(
                this.restTemplate
                    .getForObject("http://localhost:" + port + "/library/books", Books.class)
                    .getBooks().size() == 1);
    }
 
    @Test
    public void testAddBook() {
        Book book = new Book();
        
        book.setBookName("five point someone");
        book.setAuthors("Chetan Bkagat");
        book.setLibraryId(1L);
        book.setPublicationName("PVP Publication");
        book.setPublishDate(new Date());
        
        
        ResponseEntity<String> responseEntity = this.restTemplate
            .postForEntity("http://localhost:" + port + "/library/books", book, String.class);
        
        assertEquals(HttpStatus.ACCEPTED.value(), responseEntity.getStatusCodeValue());
    }
    
    @Test
    public void testUpdateBook() {
        Book book = new Book();
        
        book.setBookName("five point someone");
        
        HttpEntity<Book> requestEntity = new HttpEntity<Book>(book);
        
        ResponseEntity<String> responseEntity = this.restTemplate
            .exchange("http://localhost:" + port + "/library/books/1", HttpMethod.PUT, requestEntity, String.class);
        
        assertEquals(HttpStatus.ACCEPTED.value(), responseEntity.getStatusCodeValue());
    }
	
	
}

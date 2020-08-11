package com.library.jpa;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class BookJpa implements Cloneable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String bookName;
	
	private String authors;
	private String publicationName;
	private Date publitionDate;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "library_id", referencedColumnName = "id")
	private LibraryJpa library;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public LibraryJpa getLibrary() {
		return library;
	}
	public void setLibrary(LibraryJpa library) {
		this.library = library;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public Date getPublitionDate() {
		return publitionDate;
	}
	public void setPublitionDate(Date publitionDate) {
		this.publitionDate = publitionDate;
	}
	public String getPublicationName() {
		return publicationName;
	}
	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}
	
	
	protected Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
	
	
	
}

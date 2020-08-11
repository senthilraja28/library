package com.library.dto;

import java.util.Date;

public class Book {

	private Long libraryId;
	private Long bookId;
	private String bookName;
	private String authors;
	private Integer version;
	private String publicationName;
	private Date publishDate;
	public Long getLibraryId() {
		return libraryId;
	}
	public void setLibraryId(Long libraryId) {
		this.libraryId = libraryId;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
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
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getPublicationName() {
		return publicationName;
	}
	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	@Override
	public String toString() {
		return "Book [libraryId=" + libraryId + ", bookId=" + bookId + ", bookName=" + bookName + ", authors="
				+ authors + ", version=" + version + ", publicationName=" + publicationName
				+ ", publishDate=" + publishDate + "]";
	}
	
	
	
	
	
}

package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // make Student class as JPA entity
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Long Id;
	@Column(name = "isbn")
	private String isbn;
	@Column(name = "author")
	private String author;
	@Column(name = "book_name", nullable = false)
	private String bookName;
	//@Column(name = "soft_copy")
	private String softCopy;
	@Column(name = "edition")
	private String edition;
	
	public Book() {
		
	}
	
	public Book(String isbn, String author, String bookName,String softCopy, String edition) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.bookName = bookName;
		this.softCopy = softCopy;
		this.edition = edition;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getSoftCopy() {
		return softCopy;
	}

	public void setSoftCopy(String softCopy) {
		this.softCopy = softCopy;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}	
	
}

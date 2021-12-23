package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.model.Student;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	
	private BookRepository bookRepository;


	public BookServiceImpl(BookRepository bookRepository) {
//		super();
		this.bookRepository = bookRepository;
	}
	
	public Book saveBook(Book book) {
		return this.bookRepository.save(book);
	}

}

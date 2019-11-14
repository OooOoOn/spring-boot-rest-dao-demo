package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.daoimpl.BookDao;
import com.spring.model.Book;

@RestController
public class BookController {
	
	@Autowired
	private BookDao bookDao;
		
	@RequestMapping("/")
	public String healthCheck() {
		return "OK";
	}
	
	//Get specific book by isbn number
	@RequestMapping("/book/getbyisbn")
	public Book getbookName(@RequestParam(name="isbn", required=true) int isbn) {
		return bookDao.getBookByIsbn(isbn);
	}
	
	//Post JSON object to books list (db)
	@RequestMapping(value="/book/add", method=RequestMethod.POST, consumes = "application/json")
	public Book addBook(@RequestBody Book book) {
		bookDao.save(book);
		return bookDao.getBookByIsbn(book.getIsbn() - 1);
	}

}

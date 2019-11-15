package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.daoimpl.BookDao;
import com.spring.model.Book;
import com.spring.service.GreetingService;

@RestController
public class BookController {
	
	@Autowired
	private BookDao bookDao;
	
	@Autowired
	 private GreetingService greetingService;
	
	@Value("${spring.application.name}")
	String applicationName;
	
	@Value("${spring.application.environment}")
	String applicationEnvironment;
	
	//Several profiles using properties
	@RequestMapping("/greetingproperties")
	public String healthCheck() {
		return "This " + applicationName + " is brought to you by OooOoOn. Selected profile: " + applicationEnvironment;
	}
	
	//Several profiles using @Profile annotation
	@RequestMapping("/greetingprofiles")
	public String healthCheckProfileAnnotation() {
		return "This " + greetingService.getGreetingMsg() + " is brought to you by OooOoOn. Selected profile: " + greetingService.getProfile();
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

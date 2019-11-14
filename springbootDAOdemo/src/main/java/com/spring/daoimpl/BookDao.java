package com.spring.daoimpl;

import com.spring.dao.Dao;
import com.spring.model.Book;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BookDao implements Dao<Book> {
	
	//list is working as a database
    private List<Book> books;

    public BookDao() {
        books = new ArrayList<>();
        books.add(new Book(1, "Java"));
        books.add(new Book(2, "Python"));
        books.add(new Book(3, "Android"));
    }

    @Override
    public List<Book> getAll() {
        return books;
    }

    public Book getBookByIsbn(int isbn) {
        return books.get(isbn);
    }

	@Override
	public void save(Book book) {
		books.add(book);
		
	}

	@Override
	public void delete(Book book) {
		books.remove(book);
		
	}

}

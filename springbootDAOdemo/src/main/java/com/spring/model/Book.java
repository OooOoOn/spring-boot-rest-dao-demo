package com.spring.model;

public class Book {
	
	private int isbn;
    private String bookName;

    public Book() {
    }

    public Book(int isbn, String bookName) {
        this.isbn = isbn;
        this.bookName = bookName;
    }

	public String getBookName() {
		return bookName;
	}

	public int getIsbn() {
		return isbn;
	}
    
    

}

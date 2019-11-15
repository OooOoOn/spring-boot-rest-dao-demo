package com.spring.dao;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface Dao<T> {

	    List<T> getAll();
	    void save(T t);
	    void delete(T t);
	}


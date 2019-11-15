package com.spring.springbootDAOdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.spring.controller", "com.spring.daoimpl", "com.spring.book", "com.spring.dao", "com.spring.service"})
@SpringBootApplication 
public class SpringbootDaodemoApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDaodemoApplication.class, args);
	}

}

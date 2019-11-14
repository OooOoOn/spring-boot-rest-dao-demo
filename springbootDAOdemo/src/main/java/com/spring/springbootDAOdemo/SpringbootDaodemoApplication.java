package com.spring.springbootDAOdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication @ComponentScan({"com.spring.controller", "com.spring.daoimpl", "com.spring.book", "com.spring.dao"})
public class SpringbootDaodemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDaodemoApplication.class, args);
	}

}

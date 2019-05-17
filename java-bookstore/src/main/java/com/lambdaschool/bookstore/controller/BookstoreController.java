package com.lambdaschool.bookstore.controller;


import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.repository.AuthorRepository;
import com.lambdaschool.bookstore.repository.BookRepository;
import com.lambdaschool.bookstore.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/books")
public class BookstoreController
{
    private static final Logger logger = LoggerFactory.getLogger(Book.class);

    @Autowired
    BookService bookService;






}

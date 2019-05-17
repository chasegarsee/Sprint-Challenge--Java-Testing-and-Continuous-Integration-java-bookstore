package com.lambdaschool.bookstore.service;

import com.lambdaschool.bookstore.model.Book;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface BookService
{
    List<Book> findAll(Pageable pageable);

    void delete(long id);

    Book save (Book book);

    Book update(Book book, long id);
}

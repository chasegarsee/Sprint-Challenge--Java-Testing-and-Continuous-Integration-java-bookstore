package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface BookRepository extends PagingAndSortingRepository<Book, Long>
{
    List<Book> findByBooktitleContainingIgnoreCase(String booktitle, Pageable pageable);
}

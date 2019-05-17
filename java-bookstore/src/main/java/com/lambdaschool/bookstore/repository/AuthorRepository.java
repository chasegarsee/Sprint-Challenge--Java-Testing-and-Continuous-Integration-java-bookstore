package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.Authors;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AuthorRepository extends PagingAndSortingRepository<Authors, Long>
{
    List<Authors> findByFirstnameContainingIgnoreCase(String firstname, Pageable pageable);
}

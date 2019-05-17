package com.lambdaschool.bookstore.service;

import com.lambdaschool.bookstore.model.Authors;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AuthorsService
{
    List<Authors> findAll(Pageable pageable);
}

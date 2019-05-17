package com.lambdaschool.bookstore.service;

import com.lambdaschool.bookstore.model.Authors;
import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "authorsService")
public class AuthorsServiceImpl implements AuthorsService
{

    @Autowired
    private AuthorRepository authorrepos;

    @Override
    public List<Authors> findAll(Pageable pageable)
    {
        List<Authors> list = new ArrayList<>();
        authorrepos.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

}

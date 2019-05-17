package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.model.Authors;
import com.lambdaschool.bookstore.repository.AuthorRepository;
import com.lambdaschool.bookstore.repository.BookRepository;
import com.lambdaschool.bookstore.service.AuthorsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController
{
    private static final Logger logger = LoggerFactory.getLogger(Authors.class);

    @Autowired
    private AuthorsService authorsService;

    @ApiOperation(value = "Return All Authors", response = Authors.class, responseContainer = "List")
    @ApiImplicitParams({
                               @ApiImplicitParam(name = "page", dataType = "integr", paramType = "query",
                                                 value = "Results page you want to retrieve (0..N)"),
                               @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                                                 value = "Number of records per page."),
                               @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                                                 value = "Sorting criteria in the format: property(,asc|desc). " +
                                                         "Default sort order is ascending. " +
                                                         "Multiple sort criteria are supported.")})

    @GetMapping(value = "/authors", produces = {"application/json"})
    public ResponseEntity<?>listAllAuthors(@PageableDefault(page = 0,
                                                            size = 5)
                                                       Pageable pageable)
    {
        List<Authors> myAuthors = authorsService.findAll(pageable);
        return new ResponseEntity<>(myAuthors, HttpStatus.OK);
    }


}

package com.lambdaschool.bookstore.controller;


import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.model.ErrorDetail;
import com.lambdaschool.bookstore.repository.BookRepository;
import com.lambdaschool.bookstore.service.BookService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;


@RestController
@RequestMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
public class ManageDataController
{

    private static final Logger logger = LoggerFactory.getLogger(Book.class);

    @Autowired
    BookRepository bookrepos;

    @Autowired
    BookService bookService;

    @ApiOperation(value = "Updates a Book",
                  response = void.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Book Updated Successfully", response = void.class),
            @ApiResponse(code = 500, message = "Error updating Book", response = ErrorDetail.class)
    })

    @PutMapping(value = "/books/{Bookid}")
    public ResponseEntity<?> updateBook(
            @RequestBody
                    Book updateBook,
            @PathVariable
                    long Bookid)
    {
        logger.info("/UPDATED BOOK");
        bookService.update(updateBook, Bookid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

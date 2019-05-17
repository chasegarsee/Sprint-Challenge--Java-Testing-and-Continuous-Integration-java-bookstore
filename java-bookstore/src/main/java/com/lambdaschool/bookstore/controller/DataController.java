package com.lambdaschool.bookstore.controller;

import com.lambdaschool.bookstore.model.Author;
import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.service.AuthorService;
import com.lambdaschool.bookstore.service.BookService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DataController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

    //    GET /books
    @ApiOperation(value = "LIST OF ALL BOOKS", response=Book.class, responseContainer = "List")
    @ApiImplicitParams({
                               @ApiImplicitParam(name = "page", dataType = "integr", paramType = "query", value = "Results page you want to retrieve (0..N)"),
                               @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."),
                               @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                                                 value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.")})
    @GetMapping(value="/books")
    public ResponseEntity<?> getAllBooksPageable(@PageableDefault(page = 0, size = 5) Pageable pageable){
        return new ResponseEntity<>(bookService.findAll(pageable), HttpStatus.OK);
    }
    //    GET /authors
    @ApiOperation(value = "LIST OF ALL AUTHORS", response= Author.class, responseContainer = "List")
    @ApiImplicitParams({
                               @ApiImplicitParam(name = "page", dataType = "integr", paramType = "query", value = "Results page you want to retrieve (0..N)"),
                               @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query", value = "Number of records per page."),
                               @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                                                 value = "Sorting criteria in the format: property(,asc|desc). Default sort order is ascending. Multiple sort criteria are supported.")})
    @GetMapping(value="/authors")
    public ResponseEntity<?> getAllAuthorsPageable(@PageableDefault(page = 0, size = 5) Pageable pageable){
        return new ResponseEntity<>(authorService.findAll(pageable), HttpStatus.OK);
    }
    //    PUT /data/books/{id}
    @ApiOperation(value = "UPDATES BOOK", response=Book.class)
    @PutMapping(value="/data/books/{id}")
    public ResponseEntity<?> updateBookWithId(@Valid @RequestBody Book book, @PathVariable long id){
        return new ResponseEntity<>(bookService.update(book, id), HttpStatus.OK);
    }
    //    POST /data/books/authors{id}
    @ApiOperation(value = "ADDS AUTHOR TO BOOK", response=Book.class)
    @PostMapping(value="/data/book/{bookid}/author/{authorid}")
    public ResponseEntity<?> addAuthorToBook(@PathVariable long bookid, @PathVariable long authorid){
        return new ResponseEntity<>(bookService.addAuthor(bookid, authorid), HttpStatus.OK);
    }
    //    DELETE /data/books/{id}
    @ApiOperation(value = "DELETES BOOK")
    @DeleteMapping(value="/data/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable long id){
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
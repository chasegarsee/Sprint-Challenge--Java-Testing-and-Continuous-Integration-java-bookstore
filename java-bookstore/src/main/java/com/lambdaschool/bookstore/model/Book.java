package com.lambdaschool.bookstore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    private String booktitle;

    private String ISBN;

    @ManyToMany(mappedBy = "books")
    @JsonIgnore
    private Set<Authors> authors = new HashSet<>();

    public Book()
    {
    }

    public Book(String booktitle, String ISBN, Set<Authors> authors)
    {
        this.booktitle = booktitle;
        this.ISBN = ISBN;
        this.authors = authors;
    }

    public long getBookid()
    {
        return bookid;
    }

    public void setBoodid(long bookid)
    {
        this.bookid = bookid;
    }

    public String getBooktitle()
    {
        return booktitle;
    }

    public void setBooktitle(String booktitle)
    {
        this.booktitle = booktitle;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public void setISBN(String ISBN)
    {
        this.ISBN = ISBN;
    }

    public Set<Authors> getAuthors()
    {
        return authors;
    }

    public void setAuthors(Set<Authors> authors)
    {
        this.authors = authors;
    }
}

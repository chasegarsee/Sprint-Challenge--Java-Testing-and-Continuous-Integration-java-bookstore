package com.lambdaschool.bookstore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Authors
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    private String firstname;

    private String lastname;

    @ManyToMany
    @JoinTable(name = "authorsbooks",
               joinColumns = {@JoinColumn(name = "authorid")},
               inverseJoinColumns = {@JoinColumn(name = "bookid")})
    @JsonIgnore
    private Set<Book> books = new HashSet<>();

    public Authors()
    {
    }

    public Authors(String firstname, String lastname, Set<Book> books)
    {
        this.firstname = firstname;
        this.lastname = lastname;
        this.books = books;
    }

    public long getAuthorid()
    {
        return authorid;
    }

    public void setAuthorid(long authorid)
    {
        this.authorid = authorid;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public Set<Book> getBooks()
    {
        return books;
    }

    public void setBooks(Set<Book> books)
    {
        this.books = books;
    }
}

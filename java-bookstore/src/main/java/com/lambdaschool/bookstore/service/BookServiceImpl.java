package com.lambdaschool.bookstore.service;


import com.lambdaschool.bookstore.model.Book;
import com.lambdaschool.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "bookService")
public class BookServiceImpl implements BookService
{

    @Autowired
    private BookRepository bookrepos;

    @Override
    public List<Book> findAll(Pageable pageable)
    {
        List<Book> list = new ArrayList<>();
        bookrepos.findAll(pageable).iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id)
    {
        if (bookrepos.findById(id).isPresent())
        {
            bookrepos.deleteById(id);
        } else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Override
    public Book save(Book book)
    {
        Book newBook = new Book();

        newBook.setBooktitle(book.getBooktitle());

        return bookrepos.save(newBook);
    }

    @Override
    public Book update(Book book, long id)
    {
        Book currentBook = bookrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        if (book.getBooktitle() != null)
        {
            currentBook.setBooktitle(book.getBooktitle());
        }
        return bookrepos.save(currentBook);
    }
}

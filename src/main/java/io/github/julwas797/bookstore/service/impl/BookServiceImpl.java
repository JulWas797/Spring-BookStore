package io.github.julwas797.bookstore.service.impl;

import io.github.julwas797.bookstore.obj.book.Book;
import io.github.julwas797.bookstore.obj.book.BookGenre;
import io.github.julwas797.bookstore.repository.BookRepository;
import io.github.julwas797.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Year;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    private BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Integer id) {
        return bookRepository.getBookById(id);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void addBooks(Book... book) {
        bookRepository.saveAll(List.of(book));
    }

    @PostConstruct
    private void initBooks() {
        addBooks(
                new Book("Brave New World", "Aldous Huxley", "Chatto and Windus", Year.parse("1939"), BookGenre.SCI_FI, 19.99),
                new Book("The Road to Wigan Pier", "George Orwell", "Left Book Club", Year.parse("1937"), BookGenre.BIOGRAPHY, 29.99),
                new Book("A Game of Thrones", "George R. R. Martin", "Voyager Books", Year.parse("1996"), BookGenre.FANTASY, 14.99)
        );
    }
}

package io.github.julwas797.bookstore.service;

import io.github.julwas797.bookstore.obj.book.Book;

public interface BookService {
    Iterable<Book> getAllBooks();

    Book getBookById(Integer id);
}

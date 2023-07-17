package io.github.julwas797.bookstore.repository;

import io.github.julwas797.bookstore.book.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    Book getBookById(Integer id);
}

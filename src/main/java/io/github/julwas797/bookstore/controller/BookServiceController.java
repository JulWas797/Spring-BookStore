package io.github.julwas797.bookstore.controller;

import com.google.common.collect.Iterables;
import io.github.julwas797.bookstore.obj.book.Book;
import io.github.julwas797.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/bookService")
public class BookServiceController {

    private final BookService bookService;

    @Autowired
    private BookServiceController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/listAll")
    public ResponseEntity<Book[]> getAllBooks() {
        return new ResponseEntity<>(Iterables.toArray(bookService.getAllBooks(), Book.class), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) {
        if (Objects.nonNull(id)) {
            return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

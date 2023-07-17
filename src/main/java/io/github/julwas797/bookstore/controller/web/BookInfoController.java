package io.github.julwas797.bookstore.controller.web;

import io.github.julwas797.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookInfoController {
    private final BookService bookService;

    @Autowired
    private BookInfoController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book/{id}")
    public String getBook(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "aboutBook";
    }
}

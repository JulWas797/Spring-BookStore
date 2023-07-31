package io.github.julwas797.bookstore.controller.web;

import io.github.julwas797.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {
    private final BookService bookService;

    @Autowired
    private MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = {"", "/"})
    public String home(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "main";
    }

}

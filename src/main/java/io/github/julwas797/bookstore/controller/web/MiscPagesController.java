package io.github.julwas797.bookstore.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MiscPagesController {

    @GetMapping("/about")
    public String home() {
        return "about";
    }

}

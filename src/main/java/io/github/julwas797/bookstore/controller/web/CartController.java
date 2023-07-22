package io.github.julwas797.bookstore.controller.web;

import io.github.julwas797.bookstore.obj.cart.CartElement;
import io.github.julwas797.bookstore.util.cookies.CookieUtil;
import io.github.julwas797.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class CartController {
    private static final String COOKIE_NAME = "cart";
    private static final String COOKIE_DEFAULT = "%7B%7D";
    private final BookService bookService;
    private final CookieUtil<String, Integer> cookieUtil;

    @Autowired
    private CartController(BookService bookService, CookieUtil<String, Integer> cookieUtil) {
        this.bookService = bookService;
        this.cookieUtil = cookieUtil;
    }

    @PostMapping("/cart_add")
    public String addToCart(@CookieValue(value = COOKIE_NAME, defaultValue = COOKIE_DEFAULT) String cart, @RequestParam("id") Integer id, Model model, HttpServletResponse response) {
        var cookieMap = cookieUtil.getDeserializedCookies(cart);
        var stringId = id.toString(); // Converting int to string is less resource consuming than the other way.
        var newCount = cookieMap.getOrDefault(stringId, 0) + 1;
        cookieMap.put(stringId, newCount);
        cookieUtil.serializeAndSaveCookies(cookieMap, response, COOKIE_NAME);
        model.addAttribute("title", bookService.getBookById(id).getTitle());
        return "cartConfirmation";
    }

    @PostMapping("/cart_remove")
    public String removeFromCart(@CookieValue(value = COOKIE_NAME, defaultValue = COOKIE_DEFAULT) String cart, @RequestParam("id") Integer id, Model model, HttpServletResponse response) {
        var cookieMap = cookieUtil.getDeserializedCookies(cart);
        cookieMap.remove(id.toString());
        cookieUtil.serializeAndSaveCookies(cookieMap, response, COOKIE_NAME);
        model.addAttribute("title", bookService.getBookById(id).getTitle());
        return "cartRemoval";
    }

    @GetMapping("/cart")
    public String viewCart(@CookieValue(value = COOKIE_NAME, defaultValue = COOKIE_DEFAULT) String cart, Model model) {
        var cookieMap = cookieUtil.getDeserializedCookies(cart);
        var cartElements = new ArrayList<CartElement>();
        var total = 0.0;
        for (Map.Entry<String, Integer> entry : cookieMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            var book = bookService.getBookById(Integer.parseInt(key));
            var sumPrice = book.getPrice() * value;
            cartElements.add(new CartElement(book, value, sumPrice));
            total += sumPrice;
        }
        model.addAttribute("cart", cartElements);
        model.addAttribute("cart_total", total);
        return "cartView";
    }
}

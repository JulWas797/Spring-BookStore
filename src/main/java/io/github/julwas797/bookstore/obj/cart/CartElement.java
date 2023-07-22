package io.github.julwas797.bookstore.obj.cart;

import io.github.julwas797.bookstore.obj.book.Book;

public record CartElement(Book book, Integer count, Double sum) {

}

package io.github.julwas797.bookstore;

import io.github.julwas797.bookstore.book.Book;

public record CartElement(Book book, Integer count, Double sum) {

}

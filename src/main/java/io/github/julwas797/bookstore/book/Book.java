package io.github.julwas797.bookstore.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Year;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    private String publisher;
    private Year published;
    private BookGenre genre;
    private Double price;

    public Book(String title, String author, String publisher, Year published, BookGenre genre, Double price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.published = published;
        this.genre = genre;
        this.price = price;
    }
}
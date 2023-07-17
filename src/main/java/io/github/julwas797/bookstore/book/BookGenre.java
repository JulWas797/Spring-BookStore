package io.github.julwas797.bookstore.book;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum BookGenre {
    THRILLER("Thriller"), ROMANCE("Romance"), BIOGRAPHY("Biography"), FANTASY("Fantasy"), SCI_FI("Science Fiction");

    @Getter
    private final String name;
}

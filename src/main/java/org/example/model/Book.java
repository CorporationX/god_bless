package org.example.model;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Book {
    private static final int YEAR_THE_FIRST_BOOK = 1901;
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        String errors = "";
        if (title == null || title.isEmpty()) {
            errors += " book title is empty ";
        }
        if (author == null || author.isEmpty()) {
            errors += " book author is empty ";
        }
        if (year < Book.YEAR_THE_FIRST_BOOK) {
            errors += " year of this book doesn't match, minimum year = " +
                    Book.YEAR_THE_FIRST_BOOK + " ";
        }
        if (!errors.isBlank()) {
            throw new IllegalArgumentException(errors);
        } else {
            this.title = title;
            this.author = author;
            this.year = year;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return year == book.year && Objects.equals(title, book.title)
                && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}

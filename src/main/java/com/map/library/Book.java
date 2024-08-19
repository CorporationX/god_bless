package com.map.library;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;


@Getter
@ToString
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        if (title.isEmpty() && author.isEmpty() && year < 0) {
            throw new IllegalArgumentException("Argument is not valid");
        }
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}

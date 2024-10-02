package ru.kraiush.BJS2_32996;

import lombok.Data;

import java.util.Objects;

@Data
public class Book {
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}

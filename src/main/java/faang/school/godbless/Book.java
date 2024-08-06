package faang.school.godbless;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static faang.school.godbless.Application.library;

public class Book {
    private String title, author;
    private int year;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Книга:" +
                 " " + title +
                " " + author +
                " " + year;
    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }




}

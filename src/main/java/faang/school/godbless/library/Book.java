package faang.school.godbless.library;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Objects;
@EqualsAndHashCode
@Getter
public class Book {
    @Getter
    protected String title;
    protected String author;
    protected int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Книга: " +
                "название - " + title +
                ", автор - " + author +
                ", год издания - " + year;
    }
}

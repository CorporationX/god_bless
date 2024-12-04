package school.faang.westeros_library;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object target) {
        if (!target.getClass().getName().equals(this.getClass().getName())) {
            return false;
        }

        Book book = (Book) target;

        if (!book.getTitle().equals(this.title)
                || !book.getAuthor().equals(this.author)
                || book.getYear() != this.year) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title) * 26
                + Objects.hash(author) * 21
                + Objects.hash(year);
    }
}

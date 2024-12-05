package school.faang.sprint_1.task_45400;

import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;

@Getter
@NonNull
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.title = title;
        if (author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return "Title: '" + title
                + "', author: " + author
                + ", year: " + year;
    }
}
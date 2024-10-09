package school.faang;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Book {
    private String title;
    private String author;
    private String year;

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return getTitle() + " - " + getAuthor() + " - " + getYear();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return title.equals(book.title) && author.equals(book.author) && year.equals(book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
package school.faang;

import lombok.Data;
import java.util.Objects;

@Data
public class Book {
    private String title;
    private String author;
    private String year;

    public Book() {
    }

    public Book(String title, String author, String year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return title == book.title && author == book.author && year == book.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
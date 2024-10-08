package school.faang;

import lombok.Data;
import lombok.Getter;

import java.util.Objects;

@Data
public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String author, int year, String title) {
        this.author = author;
        this.year = year;
        this.title = title;
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, title, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return year == book.year &&
                Objects.equals(author, book.author) &&
                Objects.equals(title, book.title);
    }
}

package BJS2_19344;

import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@ToString
@Getter
public class Book {
    private final String title;
    private final String author;
    private final int yearOfPublish;

    public Book(String title, String author, int yearOfPublish) {
        this.title = title;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return yearOfPublish == book.yearOfPublish && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, yearOfPublish);
    }
}

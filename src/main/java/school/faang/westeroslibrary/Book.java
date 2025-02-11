package school.faang.westeroslibrary;

import lombok.Getter;

import java.time.Year;
import java.util.Objects;

@Getter
public class Book {
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) {
        if (title == null) {
            throw new NullPointerException("Заголовок книги не может быть равен null");
        }

        if (author == null) {
            throw new NullPointerException("Автор книги не может быть равен null");
        }

        title = title.trim();
        author = author.trim();

        if (title.isEmpty()) {
            throw new IllegalArgumentException("Заголовок книги не может быть равен пустым");
        }

        if (author.isEmpty()) {
            throw new IllegalArgumentException("Автор книги не может быть равен пустым");
        }
        if (year < 1000 || year > Year.now().getValue()) {
            throw new IllegalArgumentException("Год выпуска книги не может быть отрицательным");
        }

        this.title = title;
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
        return Objects.equals(title, book.title)
                && Objects.equals(author, book.author)
                && Objects.equals(year, book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return String.format("Book {title=%s, author=%s, year=%d}", title, author, year);
    }
}
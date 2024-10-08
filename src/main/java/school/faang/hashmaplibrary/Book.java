package school.faang.hashmaplibrary;

import lombok.ToString;

import java.util.Objects;

@ToString
public class Book {
    private final String title;
    private final String author;
    private final int year;


    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
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
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }
}

package school.faang.task45246;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int year;

    @Override
    public String toString() {
        return "Книга: " + '\''
                + title + '\''
                + " Автор: "
                + author;
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
}